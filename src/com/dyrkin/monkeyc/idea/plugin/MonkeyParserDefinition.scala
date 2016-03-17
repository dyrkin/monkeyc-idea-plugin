package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.parser.MonkeyParser
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.{Language, ASTNode, PsiParser, ParserDefinition}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.{TokenType, PsiFile, FileViewProvider, PsiElement}
import com.intellij.psi.tree.{TokenSet, IFileElementType}


class MonkeyParserDefinition extends ParserDefinition {

  val Whitespaces = TokenSet.create(TokenType.WHITE_SPACE)
  val Comments = TokenSet.create(MonkeyTypes.SINGLE_LINE_COMMENT)

  val File = new IFileElementType(Language.findInstance(classOf[MonkeyLanguage]))

  override def getWhitespaceTokens: TokenSet = Whitespaces

  override def spaceExistanceTypeBetweenTokens(astNode: ASTNode, astNode1: ASTNode): SpaceRequirements = SpaceRequirements.MAY

  override def createFile(fileViewProvider: FileViewProvider): PsiFile = new MonkeyFile(fileViewProvider)

  override def getCommentTokens: TokenSet = Comments

  override def createElement(astNode: ASTNode): PsiElement = MonkeyTypes.Factory.createElement(astNode)

  override def getStringLiteralElements: TokenSet = MonkeyTokenTypesSets.Strings

  override def createLexer(project: Project): Lexer = new MonkeyLexerAdapter

  override def getFileNodeType: IFileElementType = File

  override def createParser(project: Project): PsiParser = new MonkeyParser
}
