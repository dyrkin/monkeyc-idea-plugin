package com.dyrkin.monkeyc.idea.plugin.reference

import java.util.Date

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.dyrkin.monkeyc.idea.plugin.core.helper.SdkIndex
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyComponentName, MonkeyPsiCompositeElement}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiFileFactory, PsiReference}
import com.intellij.util.IncorrectOperationException


class MonkeyUsingSdkReference(referenceWhat: MonkeyPsiCompositeElement, fullUri: String, range: TextRange) extends PsiReference {

  override def getVariants: Array[AnyRef] = {
    val res: Array[AnyRef] = if (referenceWhat.isInstanceOf[MonkeyComponentName]) {
      val prefix = (fullUri + "1").split("\\.").init.mkString(".")
      def makeSuggestion(s: String) = s.replaceAllLiterally(s"${if (prefix.isEmpty) fullUri else prefix + "."}", "").split("\\.").head
      SdkIndex.getAllSdkUris().filter(_.startsWith(s"$fullUri")).map(makeSuggestion).toArray
    } else Array()
    res
  }

  override def getCanonicalText: String = range.substring(referenceWhat.getText)

  override def getElement: PsiElement = referenceWhat

  override def isReferenceTo(element: PsiElement): Boolean = false

  override def bindToElement(psiElement: PsiElement): PsiElement = throw new IncorrectOperationException("Library from Connect IQ SDK can't be renamed")

  override def handleElementRename(s: String): PsiElement = throw new IncorrectOperationException("Can't rename library from Connect IQ SDK")

  override def isSoft: Boolean = false

  override def getRangeInElement: TextRange = range

  override def resolve(): PsiElement = {
    SdkIndex.sdkFiles.get(fullUri).map { file =>
      //create and open pseudo file
      val factory = PsiFileFactory.getInstance(referenceWhat.getProject)
      factory.createFileFromText(fullUri, MonkeyFileType(), file, new Date().getTime, true)
    }.orNull

  }
}
