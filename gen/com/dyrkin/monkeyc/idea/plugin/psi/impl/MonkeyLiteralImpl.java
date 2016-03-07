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

public class MonkeyLiteralImpl extends MonkeyPsiCompositeElementImpl implements MonkeyLiteral {

  public MonkeyLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyStringLiteral getStringLiteral() {
    return findChildByClass(MonkeyStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getCharliteral() {
    return findChildByType(CHARLITERAL);
  }

  @Override
  @Nullable
  public PsiElement getDoubleliteral() {
    return findChildByType(DOUBLELITERAL);
  }

  @Override
  @Nullable
  public PsiElement getFloatliteral() {
    return findChildByType(FLOATLITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexLiteral() {
    return findChildByType(HEX_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getIntliteral() {
    return findChildByType(INTLITERAL);
  }

  @Override
  @Nullable
  public PsiElement getLongliteral() {
    return findChildByType(LONGLITERAL);
  }

}
