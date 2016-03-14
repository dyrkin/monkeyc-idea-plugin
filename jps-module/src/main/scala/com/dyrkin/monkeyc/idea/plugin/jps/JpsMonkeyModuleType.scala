package com.dyrkin.monkeyc.idea.plugin.jps

import org.jetbrains.jps.model.JpsDummyElement
import org.jetbrains.jps.model.ex.JpsElementTypeWithDummyProperties
import org.jetbrains.jps.model.module.JpsModuleType

/**
  * @author eugene zadyra
  */
object JpsMonkeyModuleType extends JpsElementTypeWithDummyProperties with JpsModuleType[JpsDummyElement] {

}
