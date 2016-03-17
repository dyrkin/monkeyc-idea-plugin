package com.dyrkin.monkeyc.idea.plugin.psi.reference

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyUsingReference
import com.dyrkin.monkeyc.idea.plugin.psi.base.MonkeyNamedElement
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.dyrkin.monkeyc.idea.plugin.reference.{MonkeyUsingClassReference, MonkeyUsingSdkReference}
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

/**
  * @author eugene zadyra
  */
class MonkeyUsingReferenceElementBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with MonkeyNamedElement {

  override def getReference: PsiReference = getReferences.headOption.orNull

  override def getReferences: Array[PsiReference] = {
    val parentParent = this.getParent.getParent
    if (parentParent.isInstanceOf[MonkeyUsingReference]) {
      val fullUri = parentParent.getText.cleanup
      val name = this.getText.cleanup
      if (fullUri.startsWith("Toybox")) Array(new MonkeyUsingSdkReference(this, name, fullUri))
      else Array(new MonkeyUsingClassReference(this, name, fullUri))
    } else Array()
  }
}
