package com.dyrkin.monkeyc.idea.plugin.reference

import java.util.Date

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.dyrkin.monkeyc.idea.plugin.core.helper.SdkIndex
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyPsiCompositeElement, MonkeyPsiRenameSupport}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiFileFactory, PsiReference}
import com.intellij.util.IncorrectOperationException

/**
  * @author eugene zadyra
  */
class MonkeyAsSdkReference(usingRef: MonkeyPsiCompositeElement, name: String, fullUri: String) extends PsiReference with MonkeyPsiRenameSupport {

  val offset = usingRef.getText.indexOf(name)

  val range = TextRange.create(offset, offset + name.length())

  val fileFactory = PsiFileFactory.getInstance(usingRef.getProject)

  override def getVariants: Array[AnyRef] = Array()

  override def getCanonicalText: String = name

  override def getElement: PsiElement = usingRef

  override def isReferenceTo(element: PsiElement): Boolean = element != null && element.equals(resolve())

  override def bindToElement(psiElement: PsiElement): PsiElement = throw new IncorrectOperationException("Library from Connect IQ SDK can't be renamed")

  override def handleElementRename(name: String): PsiElement = rename(usingRef, name)

  override def isSoft: Boolean = false

  override def getRangeInElement: TextRange = range

  override def resolve(): PsiElement = {
    SdkIndex.sdkFiles.get(fullUri).map { file =>
      //create and open pseudo file
      val name = fullUri.lastComponent
      fileFactory.createFileFromText(fullUri, MonkeyFileType(), file, new Date().getTime, true)
    }.orNull
  }
}
