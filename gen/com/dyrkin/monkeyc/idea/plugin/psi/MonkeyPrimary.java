// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyPrimary extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyCreator getCreator();

  @Nullable
  MonkeyIdentifierSuffix getIdentifierSuffix();

  @Nullable
  MonkeyLiteral getLiteral();

  @Nullable
  MonkeyParExpression getParExpression();

  @NotNull
  List<MonkeyReferenceExpression> getReferenceExpressionList();

  @Nullable
  MonkeySymbol getSymbol();

}
