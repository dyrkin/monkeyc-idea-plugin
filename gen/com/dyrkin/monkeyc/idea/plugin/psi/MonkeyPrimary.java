// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyPrimary extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyCreator getCreator();

  @Nullable
  MonkeyLiteral getLiteral();

  @Nullable
  MonkeyParExpression getParExpression();

  @Nullable
  MonkeyReferenceExpression getReferenceExpression();

  @Nullable
  MonkeySymbol getSymbol();

}
