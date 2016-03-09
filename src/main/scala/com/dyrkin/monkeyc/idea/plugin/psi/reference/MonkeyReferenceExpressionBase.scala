package com.dyrkin.monkeyc.idea.plugin.psi.reference

import com.dyrkin.monkeyc.idea.plugin.StringUtils
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyPsiRenameSupport
import com.dyrkin.monkeyc.idea.plugin.psi.base.{MonkeyClassDeclarationBase, MonkeyFunctionDeclarationBase}
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.reference.MonkeyVariableReference
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.Condition
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiElement, PsiFile, PsiNamedElement, PsiReference}

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
class MonkeyReferenceExpressionBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with PsiNamedElement with MonkeyPsiRenameSupport {

  def text = this.getText.cleanup

  override def getReference: PsiReference = getReferences.headOption.orNull

  override def getReferences: Array[PsiReference] = {
    lookAtFunctionParameterList().orElse(lookAtFunctionBody()).orElse(lookAtClassBody()).orElse(lookAtFile()).getOrElse(Array())
  }

  def lookAtFunctionBody() = {
    val function = findParentFunction()
    function flatMap { f =>
      val variables = f.getFunctionBodyVariableElements
      val res: Array[PsiReference] = variables.filter(_.getText == text).map { v =>
        new MonkeyVariableReference(this, text, v)
      }.toArray
      if(res.isEmpty) None else Some(res)
    }
  }

  def lookAtFunctionParameterList() = {
    val function = findParentFunction()
    function flatMap { f =>
      val parameters = f.getFunctionParameterElements
      val res: Array[PsiReference] = parameters.filter(_.getText == text).map { p =>
        new MonkeyVariableReference(this, text, p)
      }.toArray
      if(res.isEmpty) None else Some(res)
    }
  }

  def lookAtClassBody() = {
    val clazz = findParentClass()
    clazz flatMap { f =>
      val variables = f.getClassVariableNameElements ++ f.getClassConstNameElements
      val res: Array[PsiReference] = variables.filter(_.getText == text).map { v =>
        new MonkeyVariableReference(this, text, v)
      }.toArray
      if(res.isEmpty) None else Some(res)
    }
  }

  def lookAtFile() = {
    val file = findParentFile()
    file flatMap { f =>
      val as = findAsReferences(f)
      val res: Array[PsiReference] = as.filter(_.getText == text).map { a =>
        new MonkeyVariableReference(this, text, a)
      }.toArray
      if(res.isEmpty) None else Some(res)
    }
  }

  def findParentFunction(): Option[MonkeyFunctionDeclarationBase] = {
    Option(PsiTreeUtil.findFirstParent(this, new Condition[PsiElement] {
      override def value(t: PsiElement): Boolean = t != null && t.isInstanceOf[MonkeyFunctionDeclarationBase]
    }).asInstanceOf[MonkeyFunctionDeclarationBase])
  }

  def findParentClass(): Option[MonkeyClassDeclarationBase] = {
    Option(PsiTreeUtil.findFirstParent(this, new Condition[PsiElement] {
      override def value(t: PsiElement): Boolean = t != null && t.isInstanceOf[MonkeyClassDeclarationBase]
    }).asInstanceOf[MonkeyClassDeclarationBase])
  }

  def findParentFile(): Option[PsiFile] = {
    Option(this.getContainingFile)
  }

  def findAsReferences(element: PsiElement) = {
    PsiTreeUtil.findChildrenOfType(element, classOf[MonkeyAsReferenceElementBase])
  }

  override def setName(name: String): PsiElement = rename(this, name)
}
