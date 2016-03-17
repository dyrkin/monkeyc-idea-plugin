package com.dyrkin.monkeyc.idea.plugin.jps

import java.util

import org.jetbrains.jps.builders.BuildTargetType
import org.jetbrains.jps.incremental.{TargetBuilder, BuilderService, ModuleLevelBuilder}

import scala.collection.JavaConversions._


class MonkeyBuilderService extends BuilderService {


  override def createModuleLevelBuilders(): util.List[_ <: ModuleLevelBuilder] = {
    List[ModuleLevelBuilder]()
  }

  override def getTargetTypes: util.List[_ <: BuildTargetType[_]] = {
    MonkeyTargetType.Types
  }

  override def createBuilders(): util.List[_ <: TargetBuilder[_, _]] = {
    List(new MonkeyBuilder)
  }
}
