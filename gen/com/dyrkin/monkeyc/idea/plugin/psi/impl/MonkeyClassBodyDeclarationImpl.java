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

public class MonkeyClassBodyDeclarationImpl extends MonkeyPsiCompositeElementImpl implements MonkeyClassBodyDeclaration {

  public MonkeyClassBodyDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) ((MonkeyVisitor)visitor).visitClassBodyDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyBlock getBlock() {
    return findChildByClass(MonkeyBlock.class);
  }

  @Override
  @Nullable
  public MonkeyClassDeclaration getClassDeclaration() {
    return findChildByClass(MonkeyClassDeclaration.class);
  }

  @Override
  @Nullable
  public MonkeyConstDeclaration getConstDeclaration() {
    return findChildByClass(MonkeyConstDeclaration.class);
  }

  @Override
  @Nullable
  public MonkeyFieldDeclaration getFieldDeclaration() {
    return findChildByClass(MonkeyFieldDeclaration.class);
  }

  @Override
  @Nullable
  public MonkeyFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(MonkeyFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public MonkeyUsingDeclaration getUsingDeclaration() {
    return findChildByClass(MonkeyUsingDeclaration.class);
  }

}
