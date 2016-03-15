package com.dyrkin.monkeyc.idea.plugin.run

import java.io.File

import com.dyrkin.monkeyc.idea.plugin.run.simulator.Simulator
import com.intellij.execution.configurations.{CommandLineState, RunConfiguration}
import com.intellij.execution.process.{KillableColoredProcessHandler, ProcessHandler}
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.module.{Module, ModuleManager}
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.{CompilerModuleExtension, ModuleRootManager}

/**
  * @author eugene zadyra
  */
class MonkeyRunningState(environment: ExecutionEnvironment, configurationModule: MonkeyRunConfigurationModule, sdk: Sdk, targetDevice: String) extends CommandLineState(environment) {

  override def startProcess(): ProcessHandler = {
    val module = getModule
    val sdkLocation = sdk.getHomePath
    val outputPath = compilerModuleExtension(module).getCompilerOutputPath
    val program = new File(outputPath.getPath, s"${module.getName}.prg")
    val simulator = new Simulator(sdkLocation, program, targetDevice)
    simulator.runSimulatorCommand.createProcess().waitFor()
    simulator.waitUntilStarted
    new KillableColoredProcessHandler(simulator.pushAndRunCommand)
  }

  //TODO Check how to work with multimodule projects
  def getModule = {
    Option(configurationModule.getModule).getOrElse(ModuleManager.getInstance(configurationModule.getProject).getModules.head)
  }

  def compilerModuleExtension(module: Module) = {
    val moduleRootManager = ModuleRootManager.getInstance(module)
    moduleRootManager.getModuleExtension(classOf[CompilerModuleExtension])
  }
}
