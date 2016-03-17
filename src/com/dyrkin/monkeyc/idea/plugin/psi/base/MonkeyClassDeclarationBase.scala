package com.dyrkin.monkeyc.idea.plugin.psi.base

import com.dyrkin.monkeyc.idea.plugin.psi._
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import scala.collection.JavaConversions._


class MonkeyClassDeclarationBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) {

  def getClassNameElement = PsiTreeUtil.findChildOfType(this, classOf[MonkeyClassName])

  def getClassVariableNameElements = getElements(classOf[MonkeyFieldDeclaration])

  def getClassConstNameElements = getElements(classOf[MonkeyConstDeclaration])

  private def getElements[T <: PsiElement](clazz: Class[T]) = {
    val declarations = PsiTreeUtil.findChildrenOfType(this, clazz)
    val declarators = declarations.map(f => PsiTreeUtil.findChildOfType(f, classOf[MonkeyVariableDeclarator]))
    declarators.filterNot(_ == null).map(f => PsiTreeUtil.findChildOfType(f, classOf[MonkeyVariableDeclarationNameBase]))
  }

}
