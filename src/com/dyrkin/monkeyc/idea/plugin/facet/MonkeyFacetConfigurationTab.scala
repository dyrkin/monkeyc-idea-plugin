package com.dyrkin.monkeyc.idea.plugin.facet

import javax.swing.JComponent

import com.dyrkin.monkeyc.idea.plugin.jps.MonkeyConstants
import com.intellij.facet.ui.{FacetEditorTab, FacetEditorContext}

/**
  * @author eugene zadyra
  */
class MonkeyFacetConfigurationTab(editorContext: FacetEditorContext, configuration: MonkeyFacetConfiguration, page: MonkeyFacetEditorForm) extends FacetEditorTab {


  override def createComponent(): JComponent = {
    page.getPanel
  }

  override def isModified: Boolean = true

  override def reset() {
    page.setTargetDeviceId(configuration.getTargetDevice)
  }

  override def apply(): Unit = {
    configuration.setTargetDevice(page.getTargetDeviceId)
  }

  override def disposeUIResources() {
  }

  override def getDisplayName: String = MonkeyConstants.FacetTypeName
}
