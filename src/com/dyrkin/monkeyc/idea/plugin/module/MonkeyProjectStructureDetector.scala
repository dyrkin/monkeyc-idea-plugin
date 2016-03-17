package com.dyrkin.monkeyc.idea.plugin.module

import java.io.File
import java.util
import javax.swing.Icon

import com.dyrkin.monkeyc.idea.plugin.MonkeyLanguage
import com.dyrkin.monkeyc.idea.plugin.sdk.ConnectIQSdk
import com.intellij.ide.util.importProject.{ModuleDescriptor, ProjectDescriptor}
import com.intellij.ide.util.projectWizard.importSources.ProjectStructureDetector.DirectoryProcessingResult
import com.intellij.ide.util.projectWizard.importSources.{DetectedProjectRoot, DetectedSourceRoot, ProjectFromSourcesBuilder, ProjectStructureDetector}
import com.intellij.ide.util.projectWizard.{ModuleWizardStep, ProjectJdkForModuleStep}
import com.intellij.openapi.util.io.FileUtil
import com.intellij.util.containers.ContainerUtil

import scala.collection.JavaConversions._


class MonkeyProjectStructureDetector extends ProjectStructureDetector {
  override def detectRoots(dir: File, children: Array[File], base: File, result: util.List[DetectedProjectRoot]): DirectoryProcessingResult = {
    val pattern = ".*\\.mc".r.pattern
    val filesByMask = FileUtil.findFilesByMask(pattern, base)
    if (!filesByMask.isEmpty) {
      result.add(new DetectedProjectRoot(dir) {
        override def getRootTypeName: String = MonkeyLanguage().getID
      })
    }
    DirectoryProcessingResult.SKIP_CHILDREN
  }

  override def setupProjectStructure(roots: util.Collection[DetectedProjectRoot], descriptor: ProjectDescriptor, builder: ProjectFromSourcesBuilder): Unit = {
    if (!builder.hasRootsFromOtherDetectors(this)) {
      builder.setupModulesByContentRoots(descriptor, roots)
    }

    if (!roots.isEmpty && !builder.hasRootsFromOtherDetectors(this)) {
      if (descriptor.getModules.isEmpty) {
        descriptor.setModules(roots.map(root => new ModuleDescriptor(root.getDirectory, MonkeyModuleType(), ContainerUtil.emptyList[DetectedSourceRoot])).toList)
      }
    }
  }

  override def createWizardSteps(builder: ProjectFromSourcesBuilder, descriptor: ProjectDescriptor, stepIcon: Icon): util.List[ModuleWizardStep] = {
    List(new ProjectJdkForModuleStep(builder.getContext, ConnectIQSdk()))
  }
}
