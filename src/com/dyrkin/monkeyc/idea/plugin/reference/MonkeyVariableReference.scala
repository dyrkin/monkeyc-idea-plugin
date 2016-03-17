package com.dyrkin.monkeyc.idea.plugin.reference

import java.util.Date

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import com.dyrkin.monkeyc.idea.plugin.core.helper.SdkIndex
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyPsiRenameSupport, MonkeyPsiCompositeElement}
import com.dyrkin.monkeyc.idea.plugin.{MonkeyElementFactory, MonkeyFileType}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiReferenceBase, PsiElement, PsiFileFactory, PsiReference}
import com.intellij.util.IncorrectOperationException
import UTIL._


class MonkeyVariableReference(variableUsage: MonkeyPsiCompositeElement, refText: String, variableDecl: PsiElement) extends PsiReference with MonkeyPsiRenameSupport {

  val offset = variableUsage.getText.indexOf(refText)

  val range = TextRange.create(offset, offset + refText.length())

  override def getVariants: Array[AnyRef] = Array()

  override def getCanonicalText: String = refText

  override def getElement: PsiElement = variableUsage

  override def isReferenceTo(element: PsiElement): Boolean = resolve() == element

  override def bindToElement(psiElement: PsiElement): PsiElement = psiElement

  override def handleElementRename(name: String): PsiElement = rename(variableUsage, name)

  override def isSoft: Boolean = false

  override def getRangeInElement: TextRange = range

  override def resolve(): PsiElement = variableDecl
}
