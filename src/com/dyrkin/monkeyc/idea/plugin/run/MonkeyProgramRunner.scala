package com.dyrkin.monkeyc.idea.plugin.run

import com.intellij.execution.configurations.{ModuleRunProfile, RunProfile}
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.DefaultProgramRunner

/**
  * @author eugene zadyra
  */
class MonkeyProgramRunner extends DefaultProgramRunner {
  override def getRunnerId: String = "MonkeyCRunner"

  override def canRun(executorId: String, profile: RunProfile): Boolean = {
    (DefaultRunExecutor.EXECUTOR_ID == executorId) && profile.isInstanceOf[ModuleRunProfile]
  }
}
