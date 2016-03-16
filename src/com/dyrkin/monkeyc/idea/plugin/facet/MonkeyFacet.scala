package com.dyrkin.monkeyc.idea.plugin.facet

import com.dyrkin.monkeyc.idea.plugin.jps.MonkeyConstants
import com.intellij.facet.{FacetManager, FacetConfiguration, FacetType, Facet}
import com.intellij.openapi.module.Module

/**
  * @author eugene zadyra
  */
object MonkeyFacet {
  def apply(module: Module) = Option(FacetManager.getInstance(module).getFacetByType(MonkeyFacetType.TypeId))

  //should only be called from write action
  def createFacet(module: Module) {
    val facetManager = FacetManager.getInstance(module)
    val facet = facetManager.createFacet(FacetType.findInstance(classOf[MonkeyFacetType]), MonkeyConstants.FacetTypeName, null)
    val facetModel = facetManager.createModifiableModel()
    facetModel.addFacet(facet)
    facetModel.commit()
  }
}

class MonkeyFacet(facetType: FacetType[_ <: Facet[_ <: FacetConfiguration], _ <: FacetConfiguration], module: Module, name: String, configuration: MonkeyFacetConfiguration, underlyingFacet: Facet[_ <: FacetConfiguration]) extends Facet[MonkeyFacetConfiguration](facetType, module, name, configuration, underlyingFacet) {

}
