package com.dyrkin.monkeyc.idea.plugin.run.simulator

import java.io.File

import scala.util.Try

/**
  * @author eugene zadyra
  */
class Simulator(val sdkLocation: String, val program: File, val deviceId: String) extends Commands {
  val Ports = 1234 to 1238
  val Attempts = 3
  val WaitDuration = 500L

  def runSimulator() = {
    launch(prepareSimulatorCommand)
  }

  def pushAndRunApplication() = {
    val port = pushProgram()
    launch(prepareRunProgrammCommand(port))
  }

  private def pushProgram(): Int = {
    withAttempts {
      Ports.find { port =>
        Thread.sleep(WaitDuration)
        Try {
          val process = launch(preparePushProgramCommand(port))
          process.waitFor()
          process.exitValue() == 0
        } getOrElse false
      }
    } getOrElse sys.error("Unable to connect to simulator")
  }

  def withAttempts[T](f: => Option[T], attempts: Int = Attempts): Option[T] = {
    f match {
      case None => if (attempts > 0) withAttempts(f, attempts - 1) else None
      case some => some
    }
  }
}
