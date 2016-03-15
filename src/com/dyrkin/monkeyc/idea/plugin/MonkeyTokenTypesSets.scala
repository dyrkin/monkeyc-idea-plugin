package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes
import com.intellij.psi.tree.TokenSet

/**
  * @author eugene zadyra
  */
object MonkeyTokenTypesSets {
  val Strings = TokenSet.create(MonkeyTypes.STRING)

  val Identifiers = TokenSet.create(
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
}
