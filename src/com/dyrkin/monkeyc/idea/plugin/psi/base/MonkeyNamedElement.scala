package com.dyrkin.monkeyc.idea.plugin.psi.base

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyPsiCompositeElement, MonkeyPsiRenameSupport}
import com.intellij.lang.ASTNode
import com.intellij.psi.{PsiElement, PsiNamedElement}


abstract class MonkeyNamedElement(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with PsiNamedElement  with MonkeyPsiRenameSupport {
  override def getName: String = getText.cleanup

  override def setName(name: String): PsiElement = rename(this, name)
}
