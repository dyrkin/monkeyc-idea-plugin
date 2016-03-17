package com.dyrkin.monkeyc.idea.plugin.reference

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.dyrkin.monkeyc.idea.plugin.core.helper.SdkIndex
import com.dyrkin.monkeyc.idea.plugin.psi.{MonkeyClassName, MonkeyComponentName, MonkeyPsiCompositeElement}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.search.{FileTypeIndex, GlobalSearchScope}
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiElement, PsiManager, PsiReference}
import com.intellij.util.IncorrectOperationException
import com.intellij.util.indexing.FileBasedIndex

import scala.collection.JavaConversions._


class MonkeyUsingClassReference(usingRef: MonkeyPsiCompositeElement, uri: String, fullUri: String) extends PsiReference {

  val offset = usingRef.getText.indexOf(uri)

  val range = TextRange.create(offset, offset + uri.length())

  val project = usingRef.getProject

  override def getVariants: Array[AnyRef] = {
    val virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MonkeyFileType(), GlobalSearchScope.allScope(project))
    val files = virtualFiles.map(f => PsiManager.getInstance(project).findFile(f)).filterNot(_ == null)
    files.filter { f =>
      val clazz = PsiTreeUtil.findChildOfAnyType(f, classOf[MonkeyClassName])
      clazz != null
    }.map(f => PsiTreeUtil.findChildOfAnyType(f, classOf[MonkeyClassName]).getText).toArray :+ "Toybox"
  }

  override def getCanonicalText: String = uri

  override def getElement: PsiElement = usingRef

  override def isReferenceTo(element: PsiElement): Boolean = element != null && element.equals(resolve())

  override def bindToElement(psiElement: PsiElement): PsiElement = throw new IncorrectOperationException("Library from Connect IQ SDK can't be renamed")

  override def handleElementRename(s: String): PsiElement = throw new IncorrectOperationException("Can't rename library from Connect IQ SDK")

  override def isSoft: Boolean = false

  override def getRangeInElement: TextRange = range

  override def resolve(): PsiElement = {
    val virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MonkeyFileType(), GlobalSearchScope.allScope(project))
    val files = virtualFiles.map(f => PsiManager.getInstance(project).findFile(f)).filterNot(_ == null)
    files.find { f =>
      val clazz = PsiTreeUtil.findChildOfAnyType(f, classOf[MonkeyClassName])
      clazz != null && clazz.getText == uri
    }.map(f => PsiTreeUtil.findChildOfAnyType(f, classOf[MonkeyClassName])).orNull
  }
}
