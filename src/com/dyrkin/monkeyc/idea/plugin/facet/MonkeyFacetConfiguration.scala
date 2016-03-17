package com.dyrkin.monkeyc.idea.plugin.facet

import com.dyrkin.monkeyc.idea.plugin.run.CachedManifest
import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.{FacetEditorContext, FacetEditorTab, FacetValidatorsManager}
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.module.Module
import org.jdom.Element
import scala.collection.JavaConversions._


class MonkeyFacetConfiguration extends FacetConfiguration with PersistentStateComponent[MonkeyFacetState] {

  var facetState: MonkeyFacetState = new MonkeyFacetState

  override def readExternal(element: Element): Unit = {
    // goto loadState()
  }

  override def writeExternal(element: Element): Unit = {
    // goto getState()
  }

  override def createEditorTabs(facetEditorContext: FacetEditorContext, facetValidatorsManager: FacetValidatorsManager): Array[FacetEditorTab] = {
    val possibleTargets = getTargetDevices(facetEditorContext.getModule)
    Array(new MonkeyFacetConfigurationTab(facetEditorContext, this, new MonkeyFacetEditorForm, possibleTargets))
  }

  override def loadState(state: MonkeyFacetState): Unit = {
    facetState = state
  }

  def setTargetDevice(targetDevice: String): Unit = {
    facetState.setTargetDeviceId(targetDevice)
  }

  def getTargetDevice = {
    facetState.getTargetDeviceId
  }

  override def getState: MonkeyFacetState = facetState

  def getTargetDevices(module: Module) = {
    CachedManifest(module).application.products.product.map(_.id)
  }
}
