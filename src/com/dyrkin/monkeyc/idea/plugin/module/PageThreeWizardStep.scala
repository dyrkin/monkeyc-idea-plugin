package com.dyrkin.monkeyc.idea.plugin.module

import javax.swing.JComponent

import com.intellij.ide.util.projectWizard.ModuleWizardStep

/**
  * @author eugene zadyra
  */
class PageThreeWizardStep(builder: MonkeyModuleBuilder) extends ModuleWizardStep {
  val step = new PageThreeWrapper

  override def updateDataModel(): Unit = {
    builder.setPageThree(step)
  }

  override def getComponent: JComponent = step.page.getPanel

  override def updateStep(): Unit = {
    builder.fillProjectTemplatesPage(step.setTemplates)
  }
}
