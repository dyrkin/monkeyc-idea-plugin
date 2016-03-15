package com.dyrkin.monkeyc.idea.plugin.jps

import org.jdom.Element
import org.jetbrains.jps.model.{JpsElementFactory, JpsDummyElement}
import org.jetbrains.jps.model.serialization.library.JpsSdkPropertiesSerializer

/**
  * @author eugene zadyra
  */
class JpsMonkeySdkPropertiesSerializer extends JpsSdkPropertiesSerializer[JpsDummyElement](MonkeyConstants.SdkTypeId, JpsMonkeySdkType()){
  override def loadProperties(element: Element): JpsDummyElement = {
    JpsElementFactory.getInstance().createDummyElement()
  }

  override def saveProperties(p: JpsDummyElement, element: Element): Unit = {}
}
