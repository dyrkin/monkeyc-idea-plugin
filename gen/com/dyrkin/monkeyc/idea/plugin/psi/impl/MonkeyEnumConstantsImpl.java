// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes.*;
import com.dyrkin.monkeyc.idea.plugin.psi.*;

public class MonkeyEnumConstantsImpl extends MonkeyPsiCompositeElementImpl implements MonkeyEnumConstants {

  public MonkeyEnumConstantsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitEnumConstants(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MonkeyEnumConstant> getEnumConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyEnumConstant.class);
  }

}
