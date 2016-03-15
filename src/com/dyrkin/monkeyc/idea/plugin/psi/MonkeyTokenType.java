package com.dyrkin.monkeyc.idea.plugin.psi;

import com.dyrkin.monkeyc.idea.plugin.MonkeyLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MonkeyTokenType extends IElementType {

  public MonkeyTokenType(@NotNull @NonNls String debugName) {
    super(debugName, MonkeyLanguage.Instance());
  }

  @Override
  public String toString() {
    return "MonkeyTokenType." + super.toString();
  }
}
