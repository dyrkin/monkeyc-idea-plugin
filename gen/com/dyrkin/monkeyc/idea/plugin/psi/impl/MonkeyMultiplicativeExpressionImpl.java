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

public class MonkeyMultiplicativeExpressionImpl extends MonkeyPsiCompositeElementImpl implements MonkeyMultiplicativeExpression {

  public MonkeyMultiplicativeExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitMultiplicativeExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MonkeyBitwiseExpression getBitwiseExpression() {
    return findNotNullChildByClass(MonkeyBitwiseExpression.class);
  }

  @Override
  @NotNull
  public List<MonkeyPrimary> getPrimaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyPrimary.class);
  }

  @Override
  @NotNull
  public List<MonkeySelector> getSelectorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeySelector.class);
  }

}
