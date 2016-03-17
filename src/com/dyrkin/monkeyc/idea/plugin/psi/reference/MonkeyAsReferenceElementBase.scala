package com.dyrkin.monkeyc.idea.plugin.psi.reference

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyPsiRenameSupport, MonkeyUsingDeclaration, MonkeyUsingReference}
import com.dyrkin.monkeyc.idea.plugin.reference.MonkeyAsSdkReference
import com.intellij.lang.ASTNode
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiElement, PsiNamedElement, PsiReference}


class MonkeyAsReferenceElementBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with PsiNamedElement with MonkeyPsiRenameSupport {

  override def getReference: PsiReference = getReferences.headOption.orNull

  override def getReferences: Array[PsiReference] = {
    val parent = this.getParent
    if (parent.isInstanceOf[MonkeyUsingDeclaration]) {
      val using = PsiTreeUtil.findChildOfType(parent, classOf[MonkeyUsingReference]).getText
      val name = this.getText.cleanup
      if (using.startsWith("Toybox")) Array(new MonkeyAsSdkReference(this, name, using)) else Array()
    } else Array()
  }

  override def setName(name: String): PsiElement = rename(this, name)

  override def getName: String = this.getText
}
