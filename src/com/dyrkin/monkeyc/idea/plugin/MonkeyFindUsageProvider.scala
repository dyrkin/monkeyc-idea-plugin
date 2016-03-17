package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes
import com.intellij.lang.HelpID
import com.intellij.lang.cacheBuilder.{DefaultWordsScanner, WordsScanner}
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet


class MonkeyFindUsageProvider extends FindUsagesProvider {
  override def getType(psiElement: PsiElement): String = "type"

  override def getDescriptiveName(psiElement: PsiElement): String = psiElement.getText

  override def getHelpId(psiElement: PsiElement): String = HelpID.FIND_OTHER_USAGES

  override def canFindUsagesFor(psiElement: PsiElement): Boolean = true

  override def getWordsScanner: WordsScanner = {
    new DefaultWordsScanner(new MonkeyLexerAdapter(), TokenSet.create(MonkeyTypes.IDENTIFIER), TokenSet.create(MonkeyTypes.SINGLE_LINE_COMMENT), TokenSet.create(MonkeyTypes.STRING))
  }

  override def getNodeText(psiElement: PsiElement, b: Boolean): String = psiElement.getText
}
