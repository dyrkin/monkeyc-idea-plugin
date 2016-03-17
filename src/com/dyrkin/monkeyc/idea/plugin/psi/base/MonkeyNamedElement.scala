package com.dyrkin.monkeyc.idea.plugin.psi.base

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyPsiCompositeElement, MonkeyPsiRenameSupport}
import com.intellij.psi.{PsiElement, PsiNamedElement}


trait MonkeyNamedElement extends PsiNamedElement with MonkeyPsiCompositeElement with MonkeyPsiRenameSupport {
  override def getName: String = getText.cleanup

  override def setName(name: String): PsiElement = rename(this, name)
}
