package com.dyrkin.monkeyc.idea.plugin.jps

import java.util

import org.jetbrains.jps.builders.{BuildTargetLoader, ModuleBasedBuildTargetType}
import org.jetbrains.jps.model.JpsModel

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
object MonkeyTargetType {
  val Production = new MonkeyTargetType("monkey-production", false)
  val Test = new MonkeyTargetType("monkey-test", true)
  val Types = List(Production, Test)
}

class MonkeyTargetType(typeId: String, val tests: Boolean) extends ModuleBasedBuildTargetType[MonkeyTarget](typeId) {

  override def computeAllTargets(model: JpsModel): util.List[MonkeyTarget] = {
    val targets = model.getProject.getModules(JpsMonkeyModuleType()).map(module => new MonkeyTarget(this, module))
    targets.toList
  }

  override def createLoader(model: JpsModel): BuildTargetLoader[MonkeyTarget] = {
    new BuildTargetLoader[MonkeyTarget]() {
      def createTarget(targetId: String): MonkeyTarget = {
        model.getProject.getModules(JpsMonkeyModuleType()).find(_.getName == targetId).map { module =>
          new MonkeyTarget(MonkeyTargetType.this, module)
        }.orNull
      }
    }
  }
}
