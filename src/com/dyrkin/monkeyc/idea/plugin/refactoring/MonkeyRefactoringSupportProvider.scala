package com.dyrkin.monkeyc.idea.plugin.refactoring


import com.dyrkin.monkeyc.idea.plugin.psi.base.MonkeyNamedElement
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement

/**
  * @author eugene zadyra
  */
class MonkeyRefactoringSupportProvider extends RefactoringSupportProvider {
  override def isInplaceRenameAvailable(element: PsiElement, context: PsiElement): Boolean = {
    element.isInstanceOf[MonkeyNamedElement]
  }

  override def isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement): Boolean = {
    element.isInstanceOf[MonkeyNamedElement]
  }
}
