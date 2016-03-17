package com.dyrkin.monkeyc.idea.plugin.run.simulator

import java.io.File

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.intellij.execution.configurations.GeneralCommandLine

import scala.util.Try


class Simulator(val sdkLocation: String, val program: File, val deviceId: String) {

  val Ports = 1234 to 1238
  val Attempts = 3
  val WaitDuration = 500L

  def pushAndRunApplicationCommand = {
    val command = createCommand
    command.setExePath(executable(os("monkeydo", ext = ".bat")))
    command.addParameter(program.getAbsolutePath)
    command.addParameter(if (deviceId.isEmpty) "square_watch" else deviceId)
    command
  }

  def runSimulatorCommand = {
    val command = createCommand
    command.setExePath(executable(os("connectiq", winName = Some("simulator.exe"))))
    command
  }

  def waitUntilStarted: Unit = {
    runHelp()
  }

  private def prepareHelpCommand(port: Int) = {
    val command = createCommand
    command.setExePath(executable(os("shell")))
    command.addParameter("--transport=tcp")
    command.addParameter(s"--transport_args=127.0.0.1:$port")
    command.addParameter("help")
    command
  }

  private def createCommand = {
    val command = new GeneralCommandLine()
    command.withWorkDirectory(program.getParent)
    command
  }

  private def runHelp(): Int = {
    withAttempts {
      Ports.find { port =>
        Thread.sleep(WaitDuration)
        Try {
          val process = prepareHelpCommand(port).createProcess()
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
