// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyClassDeclaration extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyClassBody getClassBody();

  @Nullable
  MonkeyClassName getClassName();

  @Nullable
  MonkeyComponentName getComponentName();

  @Nullable
  MonkeyEnumBody getEnumBody();

  @NotNull
  MonkeyModifiers getModifiers();

  @Nullable
  MonkeyType getType();

}
