package com.dyrkin.monkeyc.idea.plugin.module

import javax.swing.JComponent

import com.intellij.ide.util.projectWizard.ModuleWizardStep

/**
  * @author eugene zadyra
  */
class PageTwoWizardStep(builder: MonkeyModuleBuilder) extends ModuleWizardStep {
  val step = new PageTwoWrapper

  override def updateDataModel(): Unit = {
    builder.setPageTwo(step)
  }

  override def getComponent: JComponent = step.page.getPanel
}
