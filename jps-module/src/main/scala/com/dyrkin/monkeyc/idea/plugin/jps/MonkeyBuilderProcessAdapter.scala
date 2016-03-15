package com.dyrkin.monkeyc.idea.plugin.jps

import java.io.File

import com.intellij.execution.process.{ProcessEvent, ProcessAdapter}
import com.intellij.openapi.util.Key

import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.messages.{CompilerMessage, BuildMessage}
import BuildMessage.Kind

/**
  * @author eugene zadyra
  */
class MonkeyBuilderProcessAdapter(compileContext: CompileContext, rootDirectory: File) extends ProcessAdapter {
  val Error = "ERROR:\\s*(.*)".r.unanchored
  val Warning = "WARNING:\\s*(.*)".r.unanchored
  val AssemblerException = "com.garmin.monkeybrains.asm.AssemblerException:\\s*(.*)".r.unanchored

  override def onTextAvailable(event: ProcessEvent, outputType: Key[_]): Unit = {
    val text = event.getText
    if (outputType.toString == "stderr") {
      text match {
        case Error(message) =>
          processMessage(message, BuildMessage.Kind.ERROR)
        case AssemblerException(message) =>
//          processMessage(message, BuildMessage.Kind.ERROR)
        case Warning(message) =>
          processMessage(message, BuildMessage.Kind.WARNING)
        case message =>
//          compileContext.processMessage(new CompilerMessage("Monkey C", BuildMessage.Kind.INFO, message))
      }
    }
  }

  def processMessage(message: String, kind: Kind) = {
    val fileLine = MonkeyCodeLineResolver.resolve(message)
    fileLine match {
      case Some((file, line, rest)) =>
        compileContext.processMessage(new CompilerMessage("Monkey C", kind, rest, file, -1L, -1L, -1L, line.toLong, -1L))
      case None =>
        compileContext.processMessage(new CompilerMessage("Monkey C", kind, message))
    }
  }
}
