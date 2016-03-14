package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.builders.{BuildOutputConsumer, DirtyFilesHolder}
import org.jetbrains.jps.incremental.resources.{StandardResourceBuilderEnabler, ResourcesBuilder}
import org.jetbrains.jps.incremental.{CompileContext, TargetBuilder}
import org.jetbrains.jps.model.module.JpsModule
import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyBuilder extends TargetBuilder[MonkeySourceRootDescriptor, MonkeyTarget](MonkeyTargetType.Types) {

  ResourcesBuilder.registerEnabler(new StandardResourceBuilderEnabler() {
    override def isResourceProcessingEnabled(module: JpsModule): Boolean = {
      module.getModuleType != JpsMonkeyModuleType
    }
  })

  override def build(target: MonkeyTarget, dirtyFilesHolder: DirtyFilesHolder[MonkeySourceRootDescriptor, MonkeyTarget], buildOutputConsumer: BuildOutputConsumer, compileContext: CompileContext): Unit = {

  }

  override def getPresentableName: String = {
    null
  }
}
