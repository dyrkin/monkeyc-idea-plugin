package com.dyrkin.monkeyc.idea.plugin.jps

import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import org.jetbrains.jps.model.JpsElement
import org.jetbrains.jps.model.ex.{JpsElementChildRoleBase, JpsElementBase}


object JpsMonkeyModuleExtension {
  val Kind: JpsElementChildRoleBase[JpsMonkeyModuleExtension] = JpsElementChildRoleBase.create(MonkeyConstants.FacetTypeId)
}

class JpsMonkeyModuleExtension(var properties: JpsMonkeyModuleProperties) extends JpsElementBase[JpsMonkeyModuleExtension] with JpsElement {

  override def createCopy(): JpsMonkeyModuleExtension = {
    new JpsMonkeyModuleExtension(properties)
  }

  override def applyChanges(self: JpsMonkeyModuleExtension): Unit = {
    properties = self.properties
  }
}
