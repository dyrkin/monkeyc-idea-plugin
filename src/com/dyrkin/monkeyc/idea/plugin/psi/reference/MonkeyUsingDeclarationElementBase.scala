package com.dyrkin.monkeyc.idea.plugin.psi.reference

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyUsingDeclaration
import com.dyrkin.monkeyc.idea.plugin.psi.base.MonkeyNamedElement
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.reference.{MonkeyUsingClassReference, MonkeyUsingSdkReference}
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiReference}

import scala.collection.JavaConversions._


class MonkeyUsingDeclarationElementBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) {

  self: MonkeyUsingDeclaration =>

  override def getReference: PsiReference = getReferences match {
    case Array(ref) => ref
    case _ => null
  }

  override def getReferences: Array[PsiReference] = {
    val usingComponents = getQualifiedName.getComponentNameList.toList

    val uriAndRefs = createFullUriAndRefs(usingComponents)
    uriAndRefs.map { case (uri, qualifiedRefs) =>
      val asRef = createRef(getComponentName, uri, () => getText.lastIndexOf(getComponentName.getText))
      qualifiedRefs :+ asRef toArray
    }.orNull

  }

  def createFullUriAndRefs(components: List[PsiElement]): Option[(String, List[PsiReference])] = {
    components match {
      case head :: tail =>
        val refs = tail.foldLeft(head.getText -> List(createRef(head, head.getText, () => getText.indexOf(head.getText)))) { (l, r) =>
          val uri = l._1 + "." + r.getText
          (uri, l._2 :+ createRef(r, uri, () => getText.indexOf(r.getText)))
        }
        Some(refs)
      case Nil => None
    }
  }

  def createRef(component: PsiElement, uri: String, index: () => Int) = {
    val offset = index()
    val range = TextRange.create(offset, offset + component.getText.length)
    if(uri.startsWith("Toybox.")) new MonkeyUsingSdkReference(this, uri, range)
    else new MonkeyUsingClassReference(this, uri, range)
  }

}
