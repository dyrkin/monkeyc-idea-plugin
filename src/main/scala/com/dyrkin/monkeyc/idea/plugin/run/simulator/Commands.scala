package com.dyrkin.monkeyc.idea.plugin.run.simulator


import com.dyrkin.monkeyc.idea.plugin._
import scala.language.postfixOps


/**
  * @author eugene zadyra
  */
trait Commands {
  self: Simulator =>

  def preparePushProgramCommand(port: Int) = {
    s"$sdkLocation/bin/${os("shell")} --transport=tcp --transport_args=127.0.0.1:$port push ${program.getAbsolutePath} 0:/GARMIN/APPS/${program.getName}"
  }

  def prepareRunProgrammCommand(port: Int) = {
    s"$sdkLocation/bin/${os("shell")} --transport=tcp --transport_args=127.0.0.1:$port tvm 0:/GARMIN/APPS/${program.getName} ${if (deviceId.isEmpty) "square_watch" else deviceId}"
  }

  def prepareSimulatorCommand = {
    s"$sdkLocation/bin/${os("connectiq", winName = Some("simulator.exe"))}"
  }

  def launch(f: => String): java.lang.Process = {
    Runtime.getRuntime.exec(f)
  }
}
