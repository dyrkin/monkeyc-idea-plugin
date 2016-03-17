package com.dyrkin.monkeyc.idea.plugin.facet

import javax.swing.JComponent
import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.intellij.facet.ui.{FacetEditorContext, FacetEditorTab}

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyFacetConfigurationTab(editorContext: FacetEditorContext, configuration: MonkeyFacetConfiguration, page: MonkeyFacetEditorForm, possibleTargets: Seq[String]) extends FacetEditorTab {


  override def createComponent(): JComponent = {
    page.getPanel
  }

  override def isModified: Boolean = true

  override def reset(): Unit = {
    page.setTargetDevices(possibleTargets)
    page.setTargetDeviceId(configuration.getTargetDevice)
  }

  override def apply(): Unit = {
    reset()
  }

  override def disposeUIResources() {
  }

  override def getDisplayName: String = MonkeyConstants.FacetTypeName
}
