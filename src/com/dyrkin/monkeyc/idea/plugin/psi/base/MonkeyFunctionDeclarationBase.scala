package com.dyrkin.monkeyc.idea.plugin.psi.base

import com.dyrkin.monkeyc.idea.plugin.psi._
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.reference.{MonkeyUsingClassReference, MonkeyUsingSdkReference}
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil


class MonkeyFunctionDeclarationBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) {

  def getFunctionNameElement = PsiTreeUtil.findChildOfType(this, classOf[MonkeyComponentName])

  def getFunctionParameterElements = {
    val paramsParent = PsiTreeUtil.findChildOfType(this, classOf[MonkeyFormalParameterDecls])
    PsiTreeUtil.findChildrenOfType(paramsParent, classOf[MonkeyNormalParameterDecl])
  }

  def getFunctionBodyVariableElements = {
    PsiTreeUtil.findChildrenOfType(this, classOf[MonkeyVariableDeclarationName])
  }

}
