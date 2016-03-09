package com.dyrkin.monkeyc.idea.plugin.psi.base

import com.dyrkin.monkeyc.idea.plugin.StringUtils
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyPsiRenameSupport
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.intellij.lang.ASTNode
import com.intellij.psi.{PsiElement, PsiNamedElement}

/**
  * @author eugene zadyra
  */
class MonkeyVariableDeclarationNameBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with PsiNamedElement with MonkeyPsiRenameSupport {
  override def setName(name: String): PsiElement = {
    rename(this, name)
  }

  override def getTextOffset: Int = super.getTextOffset

  override def getName: String = getText.cleanup
}
