package com.dyrkin.monkeyc.idea.plugin.jps

import java.io.File
import java.util
import java.util.Collections

import com.intellij.util.containers.ContainerUtil
import org.jetbrains.jps.builders._
import org.jetbrains.jps.builders.storage.BuildDataPaths
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.indices.{IgnoredFileIndex, ModuleExcludeIndex}
import org.jetbrains.jps.model.JpsModel
import org.jetbrains.jps.model.java.{JavaSourceRootType, JpsJavaClasspathKind, JpsJavaExtensionService}
import org.jetbrains.jps.model.module.JpsModule

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyTarget(targetType: MonkeyTargetType, module: JpsModule) extends ModuleBasedTarget[MonkeySourceRootDescriptor](targetType, module) {
  override def isTests: Boolean = targetType.tests

  override def computeDependencies(buildTargetRegistry: BuildTargetRegistry, targetOutputIndex: TargetOutputIndex): util.Collection[BuildTarget[_]] = {
    val modules = JpsJavaExtensionService.dependencies(module).includedIn(JpsJavaClasspathKind.compile(isTests)).getModules
    val dependencies = modules.filter(_.getModuleType == JpsMonkeyModuleType).map(module => new MonkeyTarget(getMonkeyTargetType, module))
    if (isTests) dependencies + new MonkeyTarget(MonkeyTargetType.Production, module) else dependencies
  }

  override def getId: String = module.getName

  override def getPresentableName: String = s"Module '${module.getName}' ${if (isTests) "tests" else "production"}"

  override def findRootDescriptor(rootId: String, rootIndex: BuildRootIndex): MonkeySourceRootDescriptor = {
    ContainerUtil.getFirstItem(rootIndex.getRootDescriptors(new File(rootId), Collections.singletonList(getMonkeyTargetType), null))
  }

  override def getOutputRoots(compileContext: CompileContext): util.Collection[File] = {
    ContainerUtil.createMaybeSingletonList(JpsJavaExtensionService.getInstance().getOutputDirectory(module, isTests()))
  }

  override def computeRootDescriptors(jpsModel: JpsModel, moduleExcludeIndex: ModuleExcludeIndex, ignoredFileIndex: IgnoredFileIndex, buildDataPaths: BuildDataPaths): util.List[MonkeySourceRootDescriptor] = {
    val rootType = if (isTests()) JavaSourceRootType.TEST_SOURCE else JavaSourceRootType.SOURCE
    val roots = myModule.getSourceRoots(rootType).map(root => new MonkeySourceRootDescriptor(root.getFile, this))
    roots.toList
  }

  private def getMonkeyTargetType: MonkeyTargetType = {
    getTargetType.asInstanceOf[MonkeyTargetType]
  }
}
