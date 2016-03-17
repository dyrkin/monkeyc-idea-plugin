package com.dyrkin.monkeyc.idea.plugin.psi

import com.dyrkin.monkeyc.idea.plugin.MonkeyElementFactory
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil


trait MonkeyPsiRenameSupport {

  def rename(element: PsiElement, newName: String) = {
    val oldId = PsiTreeUtil.findChildOfType(element, classOf[MonkeyId])
    val newId = MonkeyElementFactory.createIdentifierFromText(element.getProject, newName)
    oldId.getNode.getTreeParent.replaceChild(oldId.getNode, newId.getNode)
    element
  }
}
