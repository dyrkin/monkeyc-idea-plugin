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

public class MonkeyForStatementImpl extends MonkeyPsiCompositeElementImpl implements MonkeyForStatement {

  public MonkeyForStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitForStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyExpression getExpression() {
    return findChildByClass(MonkeyExpression.class);
  }

  @Override
  @Nullable
  public MonkeyExpressionList getExpressionList() {
    return findChildByClass(MonkeyExpressionList.class);
  }

  @Override
  @Nullable
  public MonkeyForInit getForInit() {
    return findChildByClass(MonkeyForInit.class);
  }

  @Override
  @NotNull
  public MonkeyStatement getStatement() {
    return findNotNullChildByClass(MonkeyStatement.class);
  }

}
