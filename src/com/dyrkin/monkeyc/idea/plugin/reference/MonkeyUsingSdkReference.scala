package com.dyrkin.monkeyc.idea.plugin.reference

import java.util.Date

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.dyrkin.monkeyc.idea.plugin.core.helper.SdkIndex
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyComponentName, MonkeyPsiCompositeElement}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiFileFactory, PsiReference}
import com.intellij.util.IncorrectOperationException


class MonkeyUsingSdkReference(usingRef: MonkeyPsiCompositeElement, uri: String, fullUri: String) extends PsiReference {

  val offset = usingRef.getText.indexOf(uri)

  val range = TextRange.create(offset, offset + uri.length())

  override def getVariants: Array[AnyRef] = {
    val res: Array[AnyRef] = if (usingRef.isInstanceOf[MonkeyComponentName]) {
      val prefix = (fullUri + "1").split("\\.").init.mkString(".")
      def makeSuggestion(s: String) = s.replaceAllLiterally(s"${if (prefix.isEmpty) fullUri else prefix + "."}", "").split("\\.").head
      SdkIndex.getAllSdkUris().filter(_.startsWith(s"$fullUri")).map(makeSuggestion).toArray
    } else Array()
    res
  }

  override def getCanonicalText: String = uri

  override def getElement: PsiElement = usingRef

  override def isReferenceTo(element: PsiElement): Boolean = element != null && element.equals(resolve())

  override def bindToElement(psiElement: PsiElement): PsiElement = throw new IncorrectOperationException("Library from Connect IQ SDK can't be renamed")

  override def handleElementRename(s: String): PsiElement = throw new IncorrectOperationException("Can't rename library from Connect IQ SDK")

  override def isSoft: Boolean = false

  override def getRangeInElement: TextRange = range

  override def resolve(): PsiElement = {
    val refLength = fullUri.indexOf(uri) + uri.length
    val ref = fullUri.substring(0, refLength)
    SdkIndex.sdkFiles.get(ref).map { file =>
      //create and open pseudo file
      val factory = PsiFileFactory.getInstance(usingRef.getProject)
      factory.createFileFromText(ref, MonkeyFileType(), file, new Date().getTime, true)
    }.orNull

  }
}
