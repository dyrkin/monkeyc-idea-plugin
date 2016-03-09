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

public class MonkeyRelationalExpressionImpl extends MonkeyPsiCompositeElementImpl implements MonkeyRelationalExpression {

  public MonkeyRelationalExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitRelationalExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MonkeyRelationalOp> getRelationalOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyRelationalOp.class);
  }

  @Override
  @NotNull
  public List<MonkeyShiftExpression> getShiftExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyShiftExpression.class);
  }

}
