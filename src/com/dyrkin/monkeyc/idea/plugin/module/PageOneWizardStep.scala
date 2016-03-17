package com.dyrkin.monkeyc.idea.plugin.module

import javax.swing.JComponent

import com.intellij.ide.util.projectWizard.ModuleWizardStep


class PageOneWizardStep(builder: MonkeyModuleBuilder) extends ModuleWizardStep {
  val step = new PageOneWrapper


  override def updateDataModel(): Unit = {
    builder.setPageOne(step)
  }

  override def getComponent: JComponent = step.page.getPanel
}
