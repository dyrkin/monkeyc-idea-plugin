package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.model.JpsElement
import org.jetbrains.jps.model.ex.{JpsElementChildRoleBase, JpsElementBase}

/**
  * @author eugene zadyra
  */
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
