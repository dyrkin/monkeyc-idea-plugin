// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyBitwiseExpression extends MonkeyPsiCompositeElement {

  @NotNull
  List<MonkeyBitwiseOperator> getBitwiseOperatorList();

  @NotNull
  List<MonkeyPrimary> getPrimaryList();

  @NotNull
  List<MonkeySelector> getSelectorList();

}
