package com.dyrkin.monkeyc.idea.plugin.run

import com.dyrkin.monkeyc.idea.plugin.MonkeyIcons
import com.intellij.execution.configurations._
import com.intellij.openapi.project.Project


object MonkeyConfigurationType {
  def apply() = ConfigurationTypeUtil.findConfigurationType(classOf[MonkeyConfigurationType])
}

class MonkeyConfigurationType extends ConfigurationTypeBase("MonkeyCApplication", "Monkey C Application", "Configuration to run a Connect IQ app with the simulator", MonkeyIcons.Module16) {
  val factory: ConfigurationFactory = new MonkeyConfigurationFactory(this)
  addFactory(factory)
}

class MonkeyConfigurationFactory(configuationType: ConfigurationType) extends ConfigurationFactory(configuationType) {
  override def createTemplateConfiguration(project: Project): RunConfiguration = {
    new MonkeyConfiguration("Monkey C Run Config", new MonkeyRunConfigurationModule(project), this)
  }
}
