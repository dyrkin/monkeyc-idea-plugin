package com.dyrkin.monkeyc.idea.plugin.run

import java.util

import com.intellij.diagnostic.logging.LogConfigurationPanel
import com.intellij.execution.configurations.{ConfigurationFactory, ModuleBasedConfiguration, RunConfiguration, RunProfileState}
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.{ExecutionBundle, Executor}
import com.intellij.openapi.module.{Module, ModuleManager}
import com.intellij.openapi.options.{SettingsEditor, SettingsEditorGroup}
import com.intellij.openapi.roots.{ModuleRootManager, ProjectRootManager}
import org.jdom.Element

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyConfiguration(name: String, configurationModule: MonkeyRunConfigurationModule, factory: ConfigurationFactory) extends ModuleBasedConfiguration[MonkeyRunConfigurationModule](name, configurationModule, factory) {

  var targetDevice: String = _

  override def getValidModules: util.Collection[Module] = {
    ModuleManager.getInstance(getProject).getModules.filter(m => m != null && !m.isDisposed).toList
  }

  override def getConfigurationEditor: SettingsEditor[_ <: RunConfiguration] = {
    val group = new SettingsEditorGroup[MonkeyConfiguration]
    group.addEditor(ExecutionBundle.message("run.configuration.configuration.tab.title"), new MonkeyRunConfigurationEditor(getProject))
    group.addEditor(ExecutionBundle.message("logs.tab.title"), new LogConfigurationPanel[MonkeyConfiguration])
    group
  }


  override def getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState = {
    new MonkeyRunningState(executionEnvironment, getProjectSdk, targetDevice)
  }

  def getProjectSdk = {
    val module = getConfigurationModule.getModule
    if (module != null) ModuleRootManager.getInstance(module).getSdk
    else ProjectRootManager.getInstance(getConfigurationModule.getProject).getProjectSdk
  }

  override def readExternal(element: Element): Unit = {
    super.readExternal(element)
    setTargetDevice(element.getAttributeValue("target-device"))
  }

  override def writeExternal(element: Element): Unit = {
    super.writeExternal(element)
    element.setAttribute("target-device", Option(targetDevice).getOrElse(""))
  }

  def setTargetDevice(td: String): Unit = {
    targetDevice = td
  }
}
