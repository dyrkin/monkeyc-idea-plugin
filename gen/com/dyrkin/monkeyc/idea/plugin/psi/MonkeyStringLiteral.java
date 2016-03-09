// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.dyrkin.monkeyc.idea.plugin.psi.impl.MonkeyStringLiteralEscaper;

public interface MonkeyStringLiteral extends PsiLanguageInjectionHost {

  @NotNull
  PsiElement getString();

  boolean isValidHost();

  @NotNull
  MonkeyStringLiteral updateText(String text);

  @NotNull
  MonkeyStringLiteralEscaper createLiteralTextEscaper();

}
