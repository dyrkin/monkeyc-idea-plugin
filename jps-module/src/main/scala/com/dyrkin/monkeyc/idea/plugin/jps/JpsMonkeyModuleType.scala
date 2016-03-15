package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.model.{JpsElementFactory, JpsElementTypeWithDefaultProperties, JpsSimpleElement, JpsDummyElement}
import org.jetbrains.jps.model.ex.{JpsElementTypeBase, JpsElementTypeWithDummyProperties}
import org.jetbrains.jps.model.module.JpsModuleType

/**
  * @author eugene zadyra
  */
object JpsMonkeyModuleType {
  lazy val Instance = new JpsMonkeyModuleType

  def apply() = Instance
}
class JpsMonkeyModuleType extends JpsElementTypeBase[JpsSimpleElement[JpsMonkeyModuleProperties]]
  with JpsModuleType[JpsSimpleElement[JpsMonkeyModuleProperties]]
  with JpsElementTypeWithDefaultProperties[JpsSimpleElement[JpsMonkeyModuleProperties]] {

  override def createDefaultProperties(): JpsSimpleElement[JpsMonkeyModuleProperties] = {
    JpsElementFactory.getInstance().createSimpleElement(new JpsMonkeyModuleProperties())
  }
}
