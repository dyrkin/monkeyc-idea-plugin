package com.dyrkin.monkeyc.idea.plugin.psi.base


import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyPsiRenameSupport
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyPsiCompositeElementImpl
import com.intellij.lang.ASTNode


class MonkeyVariableDeclarationNameBase(node: ASTNode) extends MonkeyNamedElement(node)  with MonkeyPsiRenameSupport {

  override def getTextOffset: Int = super.getTextOffset

}
