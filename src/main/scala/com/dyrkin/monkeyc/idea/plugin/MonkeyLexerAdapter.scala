package com.dyrkin.monkeyc.idea.plugin

import com.intellij.lexer.FlexAdapter

/**
  * @author eugene zadyra
  */
class MonkeyLexerAdapter extends FlexAdapter(new _MonkeyLexer())