package com.dyrkin.monkeyc.idea.plugin.facet

import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.{FacetEditorContext, FacetEditorTab, FacetValidatorsManager}
import com.intellij.openapi.components.PersistentStateComponent
import org.jdom.Element

/**
  * @author eugene zadyra
  */
class MonkeyFacetConfiguration extends FacetConfiguration with PersistentStateComponent[MonkeyFacetState] {

  var facetState: MonkeyFacetState = new MonkeyFacetState

  override def readExternal(element: Element): Unit = {
    // goto loadState()
  }

  override def writeExternal(element: Element): Unit = {
    // goto getState()
  }

  override def createEditorTabs(facetEditorContext: FacetEditorContext, facetValidatorsManager: FacetValidatorsManager): Array[FacetEditorTab] = {
    Array(new MonkeyFacetConfigurationTab(facetEditorContext, this, new MonkeyFacetEditorForm))
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
}
