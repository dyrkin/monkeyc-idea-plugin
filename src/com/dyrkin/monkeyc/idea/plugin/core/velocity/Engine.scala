package com.dyrkin.monkeyc.idea.plugin.core.velocity

import java.io.{FileReader, StringWriter, File}

import com.intellij.openapi.vfs.CharsetToolkit
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.log.NullLogChute
import scala.collection.JavaConversions._


object Engine {

  lazy val VelocityEngine = {
    val engine = new VelocityEngine
    engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM, new NullLogChute)
    engine.setProperty(RuntimeConstants.INPUT_ENCODING, CharsetToolkit.UTF8)
    engine.setProperty(RuntimeConstants.PARSER_POOL_SIZE, 3)
    engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "includes")
    engine.init()
    engine
  }

  def evaluateToString(map: Map[String, AnyRef], file: File) = {
    val fileReader = new FileReader(file)
    val writer = new StringWriter()
    val context = new VelocityContext(map)
    VelocityEngine.evaluate(context, writer, "Monkey", fileReader)
    writer.toString
  }

}
