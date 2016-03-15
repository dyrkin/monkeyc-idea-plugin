package com.dyrkin.monkeyc.idea.plugin.jps

import com.intellij.execution.process.{ProcessAdapter, ProcessEvent}
import com.intellij.openapi.util.Key
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage}

/**
  * @author eugene zadyra
  */
object MonkeyCodeLineResolver {
  val FileLine = "\\s*(.*):(\\d+)\\s*:\\s*(.*)".r.unanchored

  def resolve(text: String) = {
    text match {
      case FileLine(file, line, rest) => Some((file, line, rest))
      case _ => None
    }
  }

}
