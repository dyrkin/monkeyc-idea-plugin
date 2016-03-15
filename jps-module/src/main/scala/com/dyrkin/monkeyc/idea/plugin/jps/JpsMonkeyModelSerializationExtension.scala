package com.dyrkin.monkeyc.idea.plugin.jps

import java.util

import org.jdom.Element
import org.jetbrains.jps.model.JpsSimpleElement
import org.jetbrains.jps.model.module.JpsModule
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension
import org.jetbrains.jps.model.serialization.library.JpsSdkPropertiesSerializer
import org.jetbrains.jps.model.serialization.module.JpsModulePropertiesSerializer
import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
object JpsMonkeyModelSerializationExtension {
  val TargetDevicesId = "target-devices"
}

class JpsMonkeyModelSerializationExtension extends JpsModelSerializerExtension {
  override def loadRootModel(module: JpsModule, rootModel: Element): Unit = {
    val properties = module.getProperties.asInstanceOf[JpsSimpleElement[_]]
    val moduleProperties = properties.getData.asInstanceOf[JpsMonkeyModuleProperties]
    moduleProperties.TargetDevicesId = rootModel.getAttributeValue(JpsMonkeyModelSerializationExtension.TargetDevicesId)
  }

  override def getModulePropertiesSerializers: util.List[_ <: JpsModulePropertiesSerializer[_]] = {
    List(new JpsMonkeyModulePropertiesSerializer)
  }

  override def getSdkPropertiesSerializers: util.List[_ <: JpsSdkPropertiesSerializer[_]] = {
    List(new JpsMonkeySdkPropertiesSerializer)
  }
}
