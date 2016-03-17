package com.dyrkin.monkeyc.idea.plugin.module

import javax.swing.Icon

import com.dyrkin.monkeyc.idea.plugin.MonkeyIcons
import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.intellij.ide.util.projectWizard._
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.util.Condition

/**
  * @author eugene zadyra
  */
object MonkeyModuleType {
  private lazy val Instance = new MonkeyModuleType()

  def apply() = Instance
}

class MonkeyModuleType extends ModuleType[MonkeyModuleBuilder](MonkeyConstants.ModuleId) {
  override def getName: String = "Monkey C Module"

  override def getDescription: String = "Monkey C Module"

  override def getNodeIcon(b: Boolean): Icon = MonkeyIcons.Module16

  override def createModuleBuilder(): MonkeyModuleBuilder = new MonkeyModuleBuilder

  override def getBigIcon: Icon = MonkeyIcons.Module24

  override def createWizardSteps(wizardContext: WizardContext, moduleBuilder: MonkeyModuleBuilder, modulesProvider: ModulesProvider): Array[ModuleWizardStep] = {
    Array(new PageOneWizardStep(moduleBuilder), new PageTwoWizardStep(moduleBuilder), new PageThreeWizardStep(moduleBuilder)) ++ super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
  }

  override def modifyProjectTypeStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep = {
    new SdkSettingsStep(settingsStep, moduleBuilder, new Condition[SdkTypeId]() {
      override def value(sdkType: SdkTypeId): Boolean = {
        moduleBuilder.isSuitableSdkType(sdkType)
      }
    }) {
      override def updateDataModel(): Unit = {
        moduleBuilder.asInstanceOf[MonkeyModuleBuilder].onSdkSelected(myJdkComboBox.getSelectedJdk)
        super.updateDataModel()
      }
    }
  }
}
