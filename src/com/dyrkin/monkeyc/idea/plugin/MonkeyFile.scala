package com.dyrkin.monkeyc.idea.plugin

import javax.swing.Icon

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider


class MonkeyFile(val viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, MonkeyLanguage()) {
  override def getFileType: FileType = MonkeyFileType()

  override def getIcon(flags: Int): Icon = super.getIcon(flags)

  override def toString: String = "MonkeyC File"
}
