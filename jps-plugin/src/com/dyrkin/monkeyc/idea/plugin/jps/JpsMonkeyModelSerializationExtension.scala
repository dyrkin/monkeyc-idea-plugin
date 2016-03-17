package com.dyrkin.monkeyc.idea.plugin.jps

import java.util

import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.intellij.util.xmlb.XmlSerializer
import org.jdom.Element
import org.jetbrains.jps.model.module.JpsModule
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension
import org.jetbrains.jps.model.serialization.facet.JpsFacetConfigurationSerializer
import org.jetbrains.jps.model.serialization.library.JpsSdkPropertiesSerializer
import org.jetbrains.jps.model.serialization.module.JpsModulePropertiesSerializer
import org.jetbrains.jps.model.{JpsElement, JpsDummyElement, JpsElementFactory, JpsSimpleElement}

import scala.collection.JavaConversions._


object JpsMonkeyModelSerializationExtension {
  val TargetDevicesId = "target-devices"
}

class JpsMonkeyModelSerializationExtension extends JpsModelSerializerExtension {

    override def getModulePropertiesSerializers: util.List[_ <: JpsModulePropertiesSerializer[_]] = {
      val serializer = new JpsModulePropertiesSerializer[JpsDummyElement](JpsMonkeyModuleType(), "MONKEYC_MODULE", "monkey-include") {
        override def loadProperties(element: Element): JpsDummyElement = {
          JpsElementFactory.getInstance().createDummyElement()
        }

        override def saveProperties(p: JpsDummyElement, element: Element): Unit = {}
      }
      List(serializer)
    }

    override def getSdkPropertiesSerializers: util.List[_ <: JpsSdkPropertiesSerializer[_]] = {
      val serializer = new JpsSdkPropertiesSerializer[JpsDummyElement](MonkeyConstants.SdkTypeId, JpsMonkeySdkType()) {
        override def loadProperties(element: Element): JpsDummyElement = {
          JpsElementFactory.getInstance().createDummyElement()
        }

        override def saveProperties(p: JpsDummyElement, element: Element): Unit = {}
      }
      List(serializer)
    }

  val facetSerializer = new JpsFacetConfigurationSerializer[JpsMonkeyModuleExtension](JpsMonkeyModuleExtension.Kind, MonkeyConstants.FacetTypeId, MonkeyConstants.FacetTypeName) {
    override def loadExtension(facetConfigurationElement: Element, name: String, paren: JpsElement, module: JpsModule): JpsMonkeyModuleExtension = {
      new JpsMonkeyModuleExtension(XmlSerializer.deserialize(facetConfigurationElement, classOf[JpsMonkeyModuleProperties]))
    }

    override def saveExtension(extension: JpsMonkeyModuleExtension, facetConfigurationTag: Element, module: JpsModule): Unit = {
      XmlSerializer.serializeInto(extension.properties, facetConfigurationTag)
    }
  }

  override def getFacetConfigurationSerializers: util.List[_ <: JpsFacetConfigurationSerializer[_]] = {
    List(facetSerializer)
  }
}
