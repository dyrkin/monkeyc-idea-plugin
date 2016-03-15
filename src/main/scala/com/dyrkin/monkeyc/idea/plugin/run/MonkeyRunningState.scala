package com.dyrkin.monkeyc.idea.plugin.run

import java.io.File

import com.dyrkin.monkeyc.idea.plugin.run.simulator.Simulator
import com.intellij.execution.{ExecutionResult, Executor}
import com.intellij.execution.configurations.{RunnerSettings, RunConfiguration, CommandLineState}
import com.intellij.execution.process.{KillableColoredProcessHandler, ProcessHandler}
import com.intellij.execution.runners.{ProgramRunner, ExecutionEnvironment}
import com.intellij.openapi.projectRoots.Sdk

/**
  * @author eugene zadyra
  */
class MonkeyRunningState(environment: ExecutionEnvironment, sdk: Sdk, targetDevice: String) extends CommandLineState(environment) {

  var simulator: Simulator = _


//  override def execute(executor: Executor, runner: ProgramRunner[_ <: RunnerSettings]): ExecutionResult = {
//    val sdkLocation = sdk.getHomePath
//    val program = s"${getEnvironment.getProject.getName}.prg"
//    simulator = new Simulator(sdkLocation, new File(program), targetDevice)
//    new KillableColoredProcessHandler(simulator.runSimulator(), simulator.prepareSimulatorCommand)
//  }

  override def startProcess(): ProcessHandler = {
    val sdkLocation = sdk.getHomePath
    val program = s"${getEnvironment.getProject.getName}.prg"
    simulator = new Simulator(sdkLocation, new File(program), targetDevice)
    new KillableColoredProcessHandler(simulator.runSimulator(), simulator.prepareSimulatorCommand)
    new KillableColoredProcessHandler(simulator.pushAndRunApplication(), simulator.prepareSimulatorCommand)
  }

  private def getConfiguration: MonkeyConfiguration = {
    if (getEnvironment.getRunnerAndConfigurationSettings == null) {
      throw new RuntimeException("runnerAndConfigurationSettings is null")
    }
    val configuration: RunConfiguration = getEnvironment.getRunnerAndConfigurationSettings.getConfiguration
    if (configuration == null || !configuration.isInstanceOf[MonkeyConfiguration]) {
      throw new RuntimeException("runnerAndConfigurationSettings.getConfiguration() is null or wrong type")
    }
    configuration.asInstanceOf[MonkeyConfiguration]
  }
}
