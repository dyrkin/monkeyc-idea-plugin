package com.dyrkin.monkeyc.idea.plugin.module

import java.io.File
import java.nio.file.Paths
import java.util
import javax.swing.Icon

import com.dyrkin.monkeyc.idea.plugin
import com.dyrkin.monkeyc.idea.plugin.core.velocity.Engine
import com.dyrkin.monkeyc.idea.plugin.module.template.nons.ProjectInfoDomain.ProjectInfo
import com.dyrkin.monkeyc.idea.plugin.module.template.ns.ManifestDomain._
import com.dyrkin.monkeyc.idea.plugin.module.template.ns.NsMarshaller
import com.dyrkin.monkeyc.idea.plugin.sdk.ConnectIQSdk
import com.dyrkin.monkeyc.idea.plugin.settings.{MonkeySettings, TargetDeviceModuleExtension}
import com.dyrkin.monkeyc.idea.plugin.{MonkeyIcons, XmlFile}
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.ide.util.projectWizard.ModuleBuilder.ModuleConfigurationUpdater
import com.intellij.ide.util.projectWizard.{ModuleBuilder, ModuleBuilderListener, SourcePathsBuilder}
import com.intellij.openapi.module.{Module, ModuleType}
import com.intellij.openapi.projectRoots.{Sdk, SdkTypeId}
import com.intellij.openapi.roots.{ContentEntry, ModifiableRootModel}
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.{LocalFileSystem, VfsUtil, VfsUtilCore, VirtualFile}
import org.apache.commons.lang.WordUtils
import org.jetbrains.jps.model.java.JavaResourceRootType

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyModuleBuilder extends ModuleBuilder with SourcePathsBuilder with ModuleBuilderListener {

  private var pageOne: PageOneWrapper = _
  private var pageTwo: PageTwoWrapper = _
  private var pageThree: PageThreeWrapper = _
  var sourcePaths: util.List[Pair[String, String]] = _
  var resourcePaths: util.List[Pair[String, String]] = _

  var brains: ProjectInfo = _


  override def setupRootModel(rootModel: ModifiableRootModel): Unit = {
    addListener(this)
    setupSdk(rootModel)
    val contentEntry = doAddContentEntry(rootModel)
    setupSourceFolders(contentEntry)
    setupResourceFolders(contentEntry)
//    saveTargetDevice(rootModel)
    initDefaultApplication(rootModel)
    saveManifest(rootModel)
  }

  override def moduleCreated(module: Module): Unit = {
    CompilerWorkspaceConfiguration.getInstance(module.getProject).CLEAR_OUTPUT_DIRECTORY = false
  }

  override def isSuitableSdkType(sdkType: SdkTypeId): Boolean = sdkType == ConnectIQSdk()

  override def getModuleType: ModuleType[_ <: ModuleBuilder] = MonkeyModuleType()

  override def getNodeIcon: Icon = MonkeyIcons.File

  override def setSourcePaths(sp: util.List[Pair[String, String]]): Unit = {
    sourcePaths = Option(sp).orNull
  }

  override def addSourcePath(sourcePathInfo: Pair[String, String]): Unit = {
    if (sourcePaths == null) {
      sourcePaths = new util.ArrayList[Pair[String, String]]()
    }
    sourcePaths.add(sourcePathInfo)
  }

  override def getSourcePaths: util.List[Pair[String, String]] = {
    if (sourcePaths == null) {
      val paths = new util.ArrayList[Pair[String, String]]()
      paths.add(Pair.create(makePath("source"), ""))
      paths
    } else {
      sourcePaths
    }
  }

  def getResourcePaths: util.List[Pair[String, String]] = {
    if (resourcePaths == null) {
      val paths = new util.ArrayList[Pair[String, String]]()
      paths.add(Pair.create(makePath("resources"), ""))
      pageTwo.selectedLanguages.foreach { lang =>
        paths.add(Pair.create(makePath("resources-" + lang), ""))
      }
      paths
    } else {
      resourcePaths
    }
  }

  def makePath(lastPathComponent: String) = {
    val path = getContentEntryPath + File.separator + lastPathComponent
    new File(path).mkdirs()
    path
  }

  def setupSdk(rootModel: ModifiableRootModel): Unit = {
    Option(getModuleJdk) match {
      case Some(sdk) => rootModel.setSdk(sdk)
      case None => rootModel.inheritSdk()
    }
  }

  def setupSourceFolders(contentEntry: ContentEntry): Unit = {
    setupFolders(contentEntry, getSourcePaths,
      (sourceLibraryPath, pair) => contentEntry.addSourceFolder(sourceLibraryPath, false, pair.second)
    )
  }

  def setupResourceFolders(contentEntry: ContentEntry): Unit = {
    setupFolders(contentEntry, getResourcePaths,
      (sourceLibraryPath, pair) => contentEntry.addSourceFolder(sourceLibraryPath, JavaResourceRootType.RESOURCE, JavaResourceRootType.RESOURCE.createDefaultProperties())
    )
  }

  def setupFolders(contentEntry: ContentEntry, paths: util.List[Pair[String, String]], add: (VirtualFile, Pair[String, String]) => Unit): Unit = {
    if (contentEntry != null) {
      paths.foreach { pair =>
        val moduleLibraryPath = pair.first
        new File(moduleLibraryPath).mkdirs()
        val sourceLibraryPath = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(moduleLibraryPath))
        if (sourceLibraryPath != null) {
          add(sourceLibraryPath, pair)
        }
      }
    }
  }
//
//  def saveTargetDevice(rootModel: ModifiableRootModel): Unit = {
//    val extension = rootModel.getModuleExtension(classOf[TargetDeviceModuleExtension])
//    extension.setTargetDevices(pageOne.targetPlatforms.mkString(" "))
//  }

  def saveManifest(rootModel: ModifiableRootModel) = {
    val moduleName = rootModel.getModule.getName
    val appName = WordUtils.capitalize(moduleName) + "App"
    val manifest = MonkeyManifest(
      Application(
        entry = appName,
        id = plugin.genId,
        launcherIcon = "@Drawables.LauncherIcon",
        name = "@Strings.AppName",
        `type` = pageOne.applicationType,
        products = Products(pageOne.targetPlatforms.map(Product)),
        permissions = Permissions(List()),
        languages = Languages(pageTwo.selectedLanguages)
      )
    )
    val manifestContent = NsMarshaller.marshall(manifest, classOf[MonkeyManifest])
    val manifestFile = rootModel.getContentRoots.head.findFileByRelativePath("manifest.xml")
    VfsUtil.saveText(manifestFile, manifestContent)
  }

  def placeholders(appName: String) = {
    brains.newProjectFilePlaceholders.placeHolder.map(ph => (ph.value, if (!ph.sanitized) appName else s"$appName${ph.suffix}")).toMap
  }

  def shouldRename(fileName: String): Boolean = {
    val nameWithoutExtension = fileName.split("\\.").headOption
    nameWithoutExtension.exists(name => brains.newProjectFilePlaceholders.placeHolder.exists(_.suffix == name))
  }

  def initDefaultApplication(rootModel: ModifiableRootModel): Unit = {
    val appName = WordUtils.capitalize(rootModel.getModule.getName)
    val context = placeholders(appName)
    val newFilesMap = brains.newProjectFilesMaps.newProjectFileMap.filter(nfm => nfm.appType == pageOne.applicationType && nfm.name == pageThree.template).head
    val baseDir = newFilesMap.baseDir
    val sdkBinDir = ConnectIQSdk().getBinDir(rootModel.getSdk)
    newFilesMap.file.foreach { file =>
      val path = s"$baseDir/${file.path}"
      val templateFile = sdkBinDir.findFileByRelativePath(path)
      val relativeFilePathPath = Paths.get(file.path)
      val fileName = relativeFilePathPath.getFileName.toString
      val parent = relativeFilePathPath.getParent
      val toRelativeFilePath: String = file.`type` match {
        case "source" if shouldRename(fileName) => s"$parent/$appName$fileName"
        case "source" => s"$parent/$fileName"
        case "resource" => s"$parent/$fileName"
        case "manifest" => fileName
        case t => sys.error(s"Unsupported file type: $t")
      }
      val copiedFile = VfsUtil.copyFileRelative(rootModel.getProject, templateFile, rootModel.getContentRoots.head, toRelativeFilePath)

      //update template variables
      if (!copiedFile.getFileType.isBinary) {
        val content = Engine.evaluateToString(context, VfsUtilCore.virtualToIoFile(copiedFile))
        VfsUtil.saveText(copiedFile, content)
      }
    }
  }

  def onSdkSelected(sdk: Sdk): Unit = {
    val binDir = ConnectIQSdk().getBinDir(sdk)
    val projectInfoFile = binDir.findChild("projectInfo.xml").getPath
    brains = new File(projectInfoFile).makeNonsObj(classOf[ProjectInfo])
  }

  def setPageOne(_pageOne: PageOneWrapper): Unit = {
    pageOne = _pageOne
  }

  def setPageTwo(_pageTwo: PageTwoWrapper): Unit = {
    pageTwo = _pageTwo
  }

  def setPageThree(_pageThree: PageThreeWrapper): Unit = {
    pageThree = _pageThree
  }

  def fillProjectTemplatesPage(setTemplates: List[String] => Unit): Unit = {
    val templates = brains.newProjectFilesMaps.newProjectFileMap.filter(_.appType == pageOne.applicationType).map(_.name)
    setTemplates(templates.toList)
  }

  override def addModuleConfigurationUpdater(updater: ModuleConfigurationUpdater): Unit = super.addModuleConfigurationUpdater(updater)
}
