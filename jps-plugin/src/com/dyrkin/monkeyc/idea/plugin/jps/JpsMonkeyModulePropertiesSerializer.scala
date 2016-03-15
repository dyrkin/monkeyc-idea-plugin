package com.dyrkin.monkeyc.idea.plugin.jps

import org.jdom.Element
import org.jetbrains.jps.model.{JpsElementFactory, JpsSimpleElement}
import org.jetbrains.jps.model.serialization.module.JpsModulePropertiesSerializer

/**
  * @author eugene zadyra
  */
class JpsMonkeyModulePropertiesSerializer extends JpsModulePropertiesSerializer[JpsSimpleElement[JpsMonkeyModuleProperties]](JpsMonkeyModuleType(), "MONKEYC_MODULE", null) {
  override def loadProperties(element: Element): JpsSimpleElement[JpsMonkeyModuleProperties] = {
    JpsElementFactory.getInstance().createSimpleElement(new JpsMonkeyModuleProperties())
  }

  override def saveProperties(p: JpsSimpleElement[JpsMonkeyModuleProperties], element: Element): Unit = {}
}
