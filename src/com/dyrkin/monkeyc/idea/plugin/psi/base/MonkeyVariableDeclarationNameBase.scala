package com.dyrkin.monkeyc.idea.plugin.psi.base


import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyPsiRenameSupport
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.intellij.lang.ASTNode

/**
  * @author eugene zadyra
  */
class MonkeyVariableDeclarationNameBase(node: ASTNode) extends MonkeyPsiCompositeElementImpl(node) with MonkeyNamedElement with MonkeyPsiRenameSupport {

  override def getTextOffset: Int = super.getTextOffset

}
