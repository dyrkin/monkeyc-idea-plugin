package com.dyrkin.monkeyc.idea.plugin.jps


import java.io.File
import java.net.URL
import java.nio.charset.Charset

import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.BaseOSProcessHandler
import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.jps.builders.{BuildOutputConsumer, DirtyFilesHolder}
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage}
import org.jetbrains.jps.incremental.resources.{ResourcesBuilder, StandardResourceBuilderEnabler}
import org.jetbrains.jps.incremental.{CompileContext, ProjectBuildException, TargetBuilder}
import org.jetbrains.jps.model.ex.JpsElementBase
import org.jetbrains.jps.model.java.{JavaResourceRootType, JavaSourceRootType, JpsJavaExtensionService}
import org.jetbrains.jps.model.library.sdk.JpsSdk
import org.jetbrains.jps.model.module.{JpsModule, JpsModuleSourceRootType, JpsTypedModule}
import org.jetbrains.jps.model.{JpsDummyElement, JpsSimpleElement}

import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

/**
  * @author eugene zadyra
  */
class MonkeyBuilder extends TargetBuilder[MonkeySourceRootDescriptor, MonkeyTarget](MonkeyTargetType.Types) {
  val NAME = "Monkey C"

  ResourcesBuilder.registerEnabler(new StandardResourceBuilderEnabler() {
    override def isResourceProcessingEnabled(module: JpsModule): Boolean = {
      module.getModuleType != JpsMonkeyModuleType()
    }
  })


  override def build(target: MonkeyTarget, dirtyFilesHolder: DirtyFilesHolder[MonkeySourceRootDescriptor, MonkeyTarget], outputConsumer: BuildOutputConsumer, compileContext: CompileContext): Unit = {
    val isTests = target.isTests
    val jpsModule = target.getModule
    val module = jpsModule.asTyped(JpsMonkeyModuleType())
    val sdk = getSdk(compileContext, module)
    val facet = module.getContainer.getChild(JpsMonkeyModuleExtension.Kind)
    val targetDevice = facet.properties.targetDeviceId
    val outputDirectory = getOutputDirectory(module, compileContext, isTests)
    val sourceRoots = getSourceRoots(module, isTests)
    val resourceRoots = getResourceRoots(module, isTests)
    jpsModule.getContentRootsList.getUrls.foreach { url =>
      val rootDirectory = new File(new URL(url).getPath)
      val manifest = getManifestFile(rootDirectory)
      runMonkeyc(targetDevice, module, compileContext, sdk, outputConsumer, outputDirectory, sourceRoots, resourceRoots, manifest, rootDirectory)
    }
  }

  def getManifestFile(rootDirectory: File) = {
    new File(rootDirectory.getAbsolutePath, "manifest.xml")
  }

  def runMonkeyc(targetDevice: String, module: JpsTypedModule[JpsDummyElement], compileContext: CompileContext, sdk: JpsSdk[JpsDummyElement], outputConsumer: BuildOutputConsumer, outputDirectory: File, sourceRoots: Seq[File], resourceRoots: Seq[File], manifest: File, rootDirectory: File) = {
    val prgFile = makePrgFile(module.getName, outputDirectory)
    val prgDebugFile = makePrgDebugFile(module.getName, outputDirectory)
    val commandLine = getCompileCommandLine(targetDevice, sdk, prgFile, sourceRoots, resourceRoots, manifest)
    //    compileContext.processMessage(new CompilerMessage(NAME, BuildMessage.Kind.ERROR, targetDevices))
    Try(commandLine.createProcess()) match {
      case Success(process) =>
        val handler = new BaseOSProcessHandler(process, commandLine.getCommandLineString(), Charset.defaultCharset())
        val adapter = new MonkeyBuilderProcessAdapter(compileContext, rootDirectory)
        handler.addProcessListener(adapter)
        handler.startNotify()
        handler.waitFor()
      case Failure(ex) => throw new ProjectBuildException("Failed to launch monkeyc compiler", ex)
    }
    consumeOutput(outputConsumer, prgFile, prgDebugFile)
  }


  def getCompileCommandLine(targetDevice: String, sdk: JpsSdk[JpsDummyElement], targetFile: File, sourceRoots: Seq[File], resourceRoots: Seq[File], manifest: File) = {
    val compiler = getCompiler(sdk)
    val commandLine = new GeneralCommandLine()
    commandLine.withWorkDirectory(targetFile.getParentFile)
    commandLine.setExePath(compiler.getAbsolutePath)
    commandLine.addParameter("-m")
    commandLine.addParameter(manifest.getAbsolutePath)
    commandLine.addParameter("-o")
    commandLine.addParameter(targetFile.getAbsolutePath)
    getSourceFiles(sourceRoots).foreach(sf => commandLine.addParameter(sf))
    commandLine.addParameter("-z")
    commandLine.addParameter(getResourceFiles(resourceRoots))
    commandLine.addParameter("-d")
    commandLine.addParameter(if (targetDevice.isEmpty) "square_watch" else targetDevice)
    commandLine
  }


  def getSourceFiles(sourceRoots: Seq[File]) = {
    getFilesByExtension(sourceRoots, "mc").map(_.getAbsolutePath)
  }

  def getResourceFiles(resourceRoots: Seq[File]) = {
    getFilesByExtension(resourceRoots, "xml").map(_.getAbsolutePath).mkString(if (isWin) ";" else ":")
  }

  def getFilesByExtension(roots: Seq[File], extension: String) = {
    roots.flatMap(sr => find(sr, extension))
  }

  def find(file: File, extensions: String*) = {
    def find(f: File): Array[File] = {
      val these = f.listFiles
      these ++ these.filter(_.isDirectory).flatMap(find)
    }
    find(file).filter(f => extensions.exists(ext => f.getName.endsWith(s".$ext")))
  }

  def getCompiler(sdk: JpsSdk[JpsDummyElement]) = {
    new File(s"${sdk.getHomePath}${File.separator}bin", if (isWin) "monkeyc.bat" else "monkeyc")
  }

  def consumeOutput(outputConsumer: BuildOutputConsumer, files: File*) = {
    files.foreach(f => if (f.exists()) outputConsumer.registerOutputFile(f, List(f.getAbsolutePath)))
  }

  lazy val isWin = sys.props("os.name").toLowerCase().contains("win")

  def makePrgFile(moduleName: String, outputDirectory: File) = {
    new File(outputDirectory, s"$moduleName.prg")
  }

  def makePrgDebugFile(moduleName: String, outputDirectory: File) = {
    new File(outputDirectory, s"$moduleName.prg.debug.xml")
  }

  def getSourceRoots(module: JpsTypedModule[JpsDummyElement], isTests: Boolean) = {
    if (isTests) getRoots(module, JavaSourceRootType.SOURCE, JavaSourceRootType.TEST_SOURCE)
    else getRoots(module, JavaSourceRootType.SOURCE)
  }

  def getResourceRoots(module: JpsTypedModule[JpsDummyElement], isTests: Boolean) = {
    if (isTests) getRoots(module, JavaResourceRootType.RESOURCE, JavaResourceRootType.TEST_RESOURCE)
    else getRoots(module, JavaResourceRootType.RESOURCE)
  }

  def getRoots[T <: JpsElementBase[T]](module: JpsTypedModule[JpsDummyElement], sourceTypes: JpsModuleSourceRootType[T]*) = {
    sourceTypes.flatMap(st => module.getSourceRoots(st)).map(_.getFile)
  }

  def getSdk(compileContext: CompileContext, module: JpsTypedModule[JpsDummyElement]) = {
    module.getSdk(JpsMonkeySdkType())
  }

  def getOutputDirectory(module: JpsTypedModule[JpsDummyElement], compileContext: CompileContext, isTests: Boolean) = {
    val javaExtensionService: JpsJavaExtensionService = JpsJavaExtensionService.getInstance
    val outputDirectory = Option(javaExtensionService.getOutputDirectory(module, isTests))
    outputDirectory match {
      case Some(dir) =>
        if (!dir.exists()) FileUtil.createDirectory(dir)
        dir
      case None =>
        val errorMessage: String = "No output dir for module " + module.getName
        compileContext.processMessage(new CompilerMessage(NAME, BuildMessage.Kind.ERROR, errorMessage))
        throw new ProjectBuildException(errorMessage)
    }
  }


  override def getPresentableName: String = MonkeyConstants.Name
}
