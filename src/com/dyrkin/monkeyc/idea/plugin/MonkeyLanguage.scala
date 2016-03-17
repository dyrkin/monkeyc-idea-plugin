package com.dyrkin.monkeyc.idea.plugin

import com.intellij.lang.Language


object MonkeyLanguage {
  val Instance = new MonkeyLanguage

  def apply() = Instance
}
class MonkeyLanguage extends Language("MonkeyC")
