// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyFunctionDeclaration extends MonkeyPsiCompositeElement {

  @NotNull
  List<MonkeyBlockStatement> getBlockStatementList();

  @NotNull
  MonkeyComponentName getComponentName();

  @Nullable
  MonkeyExplicitConstructorInvocation getExplicitConstructorInvocation();

  @Nullable
  MonkeyFormalParameters getFormalParameters();

  @NotNull
  MonkeyModifiers getModifiers();

  @Nullable
  MonkeyQualifiedNameList getQualifiedNameList();

}
