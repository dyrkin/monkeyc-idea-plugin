package com.dyrkin.monkeyc.idea.plugin.run

import com.intellij.execution.actions.{ConfigurationContext, RunConfigurationProducer}
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

/**
  * @author eugene zadyra
  */
class MonkeyRunConfigurationProducer extends RunConfigurationProducer[MonkeyConfiguration](MonkeyConfigurationType()) {
  override def setupConfigurationFromContext(configuration: MonkeyConfiguration, context: ConfigurationContext, sourceElement: Ref[PsiElement]): Boolean = {
    Option(context.getLocation).exists { location =>
      Option(context.getModule).foreach { module =>
        configuration.setModule(module)
        configuration.setName(module.getName)
      }
      configuration.setTargetDevice("square_watch")
      true
    }
  }

  override def isConfigurationFromContext(configuration: MonkeyConfiguration, context: ConfigurationContext): Boolean = {
    Option(context.getModule).contains(configuration.getConfigurationModule.getModule)
  }
}
