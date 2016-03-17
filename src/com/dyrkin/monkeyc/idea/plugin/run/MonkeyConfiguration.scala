package com.dyrkin.monkeyc.idea.plugin.run

import java.util

import com.dyrkin.monkeyc.idea.plugin.facet.MonkeyFacet
import com.intellij.diagnostic.logging.LogConfigurationPanel
import com.intellij.execution.configurations.{ConfigurationFactory, ModuleBasedConfiguration, RunConfiguration, RunProfileState}
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.{ExecutionBundle, Executor}
import com.intellij.openapi.module.{Module, ModuleManager}
import com.intellij.openapi.options.{SettingsEditor, SettingsEditorGroup}
import com.intellij.openapi.roots.{ModuleRootManager, ProjectRootManager}
import org.jdom.Element

import scala.collection.JavaConversions._


class MonkeyConfiguration(name: String, configurationModule: MonkeyRunConfigurationModule, factory: ConfigurationFactory) extends ModuleBasedConfiguration[MonkeyRunConfigurationModule](name, configurationModule, factory) {

  var targetDevice: String = _

  override def getValidModules: util.Collection[Module] = {
    ModuleManager.getInstance(getProject).getModules.filter(m => m != null && !m.isDisposed).toList
  }

  override def getConfigurationEditor: SettingsEditor[_ <: RunConfiguration] = {
    val module = getValidModules.head
    val group = new SettingsEditorGroup[MonkeyConfiguration]
    group.addEditor(ExecutionBundle.message("run.configuration.configuration.tab.title"), new MonkeyRunConfigurationEditor(getTargetDevices(module)))
    group.addEditor(ExecutionBundle.message("logs.tab.title"), new LogConfigurationPanel[MonkeyConfiguration])
    group
  }

  def getTargetDevices(module: Module) = {
    CachedManifest(module).application.products.product.map(_.id)
  }


  override def getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState = {
    new MonkeyRunningState(executionEnvironment, getConfigurationModule, getProjectSdk, targetDevice)
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
    getMonkeyFacet.foreach(_.getConfiguration.setTargetDevice(targetDevice))
  }

  //TODO Module based
  private def getMonkeyFacet = {
    val module = Option(getConfigurationModule.getModule).orElse(ModuleManager.getInstance(getProject).getModules.headOption)
    module.flatMap(m => MonkeyFacet(m))
  }
}
