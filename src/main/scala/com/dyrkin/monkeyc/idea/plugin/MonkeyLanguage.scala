package com.dyrkin.monkeyc.idea.plugin

import com.intellij.lang.Language

/**
  * @author eugene zadyra
  */
object MonkeyLanguage {
  val Instance = new MonkeyLanguage

  def apply() = Instance
}
class MonkeyLanguage extends Language("MonkeyC")
