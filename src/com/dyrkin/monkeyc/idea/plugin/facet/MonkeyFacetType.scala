package com.dyrkin.monkeyc.idea.plugin.facet

import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.dyrkin.monkeyc.idea.plugin.module.MonkeyModuleType
import com.intellij.facet.{FacetConfiguration, FacetTypeId, Facet, FacetType}
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.{ModuleType, Module}

/**
  * @author eugene zadyra
  */
object MonkeyFacetType {
  val TypeId = new FacetTypeId[MonkeyFacet](MonkeyConstants.FacetTypeId)
}
class MonkeyFacetType extends FacetType[MonkeyFacet, MonkeyFacetConfiguration](MonkeyFacetType.TypeId, MonkeyConstants.FacetTypeId, MonkeyConstants.FacetTypeName) {
  override def createDefaultConfiguration(): MonkeyFacetConfiguration = new MonkeyFacetConfiguration

  override def createFacet(module: Module, name: String, configuration: MonkeyFacetConfiguration, underlyingFacet: Facet[_ <: FacetConfiguration]): MonkeyFacet = {
    new MonkeyFacet(this, module, name, configuration, underlyingFacet)
  }

  override def isSuitableModuleType(moduleType: ModuleType[_ <: ModuleBuilder]): Boolean = moduleType.isInstanceOf[MonkeyModuleType]
}
