package com.dyrkin.monkeyc.idea.plugin.run.simulator

import java.io.File

import com.dyrkin.monkeyc.idea.plugin._
import com.intellij.execution.configurations.GeneralCommandLine

import scala.util.Try

/**
  * @author eugene zadyra
  */
class Simulator(val sdkLocation: String, val program: File, val deviceId: String) {

  val Ports = 1234 to 1238
  val Attempts = 3
  val WaitDuration = 500L

  def pushAndRunCommand = {
    val command = createCommand
    command.setExePath(executable(os("monkeydo", ext = ".bat")))
    command.addParameter(program.getAbsolutePath)
    command.addParameter("-d")
    command.addParameter(if (deviceId.isEmpty) "square_watch" else deviceId)
    command
  }

  def runSimulatorCommand = {
    val command = createCommand
    command.setExePath(executable(os("connectiq", winName = Some("simulator.exe"))))
    command
  }

  def waitUntilStarted: Unit = {
    pushProgram()
  }

  private def preparePushProgramCommand(port: Int) = {
    val command = createCommand
    command.setExePath(executable(os("shell")))
    command.addParameter("--transport=tcp")
    command.addParameter(s"--transport_args=127.0.0.1:$port")
    command.addParameter("push")
    command.addParameter(program.getAbsolutePath)
    command.addParameter(s"0:/GARMIN/APPS/${program.getName}")
    command
  }

  private def createCommand = {
    val command = new GeneralCommandLine()
    command.withWorkDirectory(program.getParent)
    command
  }

  private def pushProgram(): Int = {
    withAttempts {
      Ports.find { port =>
        Thread.sleep(WaitDuration)
        Try {
          val process = preparePushProgramCommand(port).createProcess()
          process.waitFor()
          process.exitValue() == 0
        } getOrElse false
      }
    } getOrElse sys.error("Unable to connect to simulator")
  }

  private def withAttempts[T](f: => Option[T], attempts: Int = Attempts): Option[T] = {
    f match {
      case None => if (attempts > 0) withAttempts(f, attempts - 1) else None
      case some => some
    }
  }

  private def executable(name: String) = {
    s"$sdkLocation${File.separator}bin${File.separator}$name"
  }
}
