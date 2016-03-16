package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.model._
import org.jetbrains.jps.model.ex.{JpsElementTypeBase, JpsElementTypeWithDummyProperties}
import org.jetbrains.jps.model.module.JpsModuleType

/**
  * @author eugene zadyra
  */
object JpsMonkeyModuleType {
  lazy val Instance = new JpsMonkeyModuleType

  def apply() = Instance
}

class JpsMonkeyModuleType extends JpsElementTypeWithDummyProperties with JpsModuleType[JpsDummyElement]