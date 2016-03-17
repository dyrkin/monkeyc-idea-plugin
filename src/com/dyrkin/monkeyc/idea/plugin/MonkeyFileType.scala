package com.dyrkin.monkeyc.idea.plugin

import javax.swing.Icon
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable


import com.intellij.openapi.fileTypes.LanguageFileType


object MonkeyFileType {
  val Instance = new MonkeyFileType

  def apply() = Instance
}

class MonkeyFileType extends LanguageFileType(MonkeyLanguage()) {

  @NotNull def getName: String = "Monkey C"

  @NotNull def getDescription: String = "Monkey C source file"

  @NotNull def getDefaultExtension: String = "mc"

  @Nullable def getIcon: Icon = MonkeyIcons.File
}
