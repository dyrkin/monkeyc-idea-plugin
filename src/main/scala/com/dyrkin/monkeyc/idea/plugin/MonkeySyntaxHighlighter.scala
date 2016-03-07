package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors._
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey._
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.{IElementType, TokenSet}

/**
  * @author eugene zadyra
  */
class MonkeySyntaxHighlighter extends SyntaxHighlighterBase {
  val McLineComment = TextAttributesKey.createTextAttributesKey("MC.LINE_COMMENT", LINE_COMMENT)
  val McBlockComment = TextAttributesKey.createTextAttributesKey("MC.BLOCK_COMMENT", BLOCK_COMMENT)
  val McClassName = createTextAttributesKey("MC.CLASS_NAME", CLASS_NAME)
  val McFunctionDeclaration = createTextAttributesKey("MC.FUNCTION_DECLARATION", FUNCTION_DECLARATION)
  val McKeyword = createTextAttributesKey("MC.KEYWORD", KEYWORD)
  val McOperator = createTextAttributesKey("MC.OPERATOR", OPERATION_SIGN)
  val McString = createTextAttributesKey("MC.STRING", STRING)
  val McNumber = createTextAttributesKey("MC.NUMBER", NUMBER)

  val KeywordTokens = TokenSet.create(
    MonkeyTypes.AND,
    MonkeyTypes.AS,
    MonkeyTypes.CLASS,
    MonkeyTypes.CONST,
    MonkeyTypes.DO,
    MonkeyTypes.ELSE,
    MonkeyTypes.ENUM,
    MonkeyTypes.EXTENDS,
    MonkeyTypes.FALSE,
    MonkeyTypes.FOR,
    MonkeyTypes.FUNCTION,
    MonkeyTypes.HAS,
    MonkeyTypes.HIDDEN,
    MonkeyTypes.IF,
    MonkeyTypes.INSTANCEOF,
    MonkeyTypes.MODULE,
    MonkeyTypes.NATIVE,
    MonkeyTypes.NEW,
    MonkeyTypes.NULL,
    MonkeyTypes.OR,
    MonkeyTypes.RETURN,
    MonkeyTypes.STATIC,
    MonkeyTypes.TRUE,
    MonkeyTypes.USING,
    MonkeyTypes.VAR,
    MonkeyTypes.WHILE
  )
  val OperatorTokens = TokenSet.create(
    MonkeyTypes.PLUS,
    MonkeyTypes.SUB,
    MonkeyTypes.STAR,
    MonkeyTypes.SLASH
  )
  val NumberLiterals = TokenSet.create(
    MonkeyTypes.INTLITERAL,
    MonkeyTypes.LONGLITERAL,
    MonkeyTypes.FLOATLITERAL,
    MonkeyTypes.DOUBLELITERAL,
    MonkeyTypes.HEX_LITERAL
  )

  val TypeKeyMap = Map[IElementType, TextAttributesKey](
    MonkeyTypes.SINGLE_LINE_COMMENT -> McLineComment,
    MonkeyTypes.BLOCK_COMMENT -> McBlockComment) ++
    map(McKeyword, KeywordTokens) ++
    map(McOperator, OperatorTokens) ++
    map(McString, MonkeyTokenTypesSets.Strings) ++
    map(McNumber, NumberLiterals)

  def map(key: TextAttributesKey, set: TokenSet) = set.getTypes map (_ -> key)

  override def getHighlightingLexer: Lexer = new MonkeyLexerAdapter

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {
    TypeKeyMap.get(tokenType) map (Array(_)) getOrElse Array()
  }
}
