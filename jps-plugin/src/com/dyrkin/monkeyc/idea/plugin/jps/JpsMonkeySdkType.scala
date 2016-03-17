package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.model.{JpsElementFactory, JpsElementTypeWithDefaultProperties, JpsDummyElement}
import org.jetbrains.jps.model.library.sdk.JpsSdkType


object JpsMonkeySdkType {
  lazy val Instance = new JpsMonkeySdkType

  def apply() = Instance
}
class JpsMonkeySdkType extends JpsSdkType[JpsDummyElement] with JpsElementTypeWithDefaultProperties[JpsDummyElement] {
  override def createDefaultProperties(): JpsDummyElement = {
    JpsElementFactory.getInstance().createDummyElement()
  }
}
