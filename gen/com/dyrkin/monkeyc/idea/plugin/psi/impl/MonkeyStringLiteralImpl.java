// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes.*;
import com.dyrkin.monkeyc.idea.plugin.psi.*;

public class MonkeyStringLiteralImpl extends MonkeyPsiCompositeElementImpl implements MonkeyStringLiteral {

  public MonkeyStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitStringLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

  public boolean isValidHost() {
    return MonkeyPsiImplUtil.isValidHost(this);
  }

  @NotNull
  public MonkeyStringLiteral updateText(String text) {
    return MonkeyPsiImplUtil.updateText(this, text);
  }

  @NotNull
  public MonkeyStringLiteralEscaper createLiteralTextEscaper() {
    return MonkeyPsiImplUtil.createLiteralTextEscaper(this);
  }

}
