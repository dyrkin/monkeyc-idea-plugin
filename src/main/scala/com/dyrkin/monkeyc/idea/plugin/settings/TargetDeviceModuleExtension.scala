package com.dyrkin.monkeyc.idea.plugin.settings

import com.dyrkin.monkeyc.idea.plugin.jps.JpsMonkeyModelSerializationExtension
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.{ModuleRootManager, ModuleExtension}
import org.jdom.Element

/**
  * @author eugene zadyra
  */
object TargetDeviceModuleExtension {
  def apply(module: Module) = ModuleRootManager.getInstance(module).getModuleExtension(classOf[TargetDeviceModuleExtension])
}

class TargetDeviceModuleExtension(var source: Option[TargetDeviceModuleExtension], writable: Boolean) extends ModuleExtension[TargetDeviceModuleExtension] {

  val TargetDevicesId = JpsMonkeyModelSerializationExtension.TargetDevicesId

  var targetDevices: String = _

  def this() {
    this(None, false)
  }

  override def isChanged: Boolean = source.exists(_.targetDevices != targetDevices)

  override def getModifiableModel(writable: Boolean): ModuleExtension[TargetDeviceModuleExtension] = new TargetDeviceModuleExtension(Some(this), writable)

  override def commit(): Unit = {
    source.find(_.targetDevices != targetDevices).foreach(_.targetDevices = targetDevices)
  }

  override def dispose(): Unit = {
    source = None
    targetDevices = null
  }

  override def readExternal(element: Element): Unit = {
    targetDevices = element.getAttributeValue(TargetDevicesId)
  }

  override def writeExternal(element: Element): Unit = {
    element.setAttribute(TargetDevicesId, targetDevices)
  }

  def setTargetDevices(td: String): Unit = {
    targetDevices = td
  }
}
