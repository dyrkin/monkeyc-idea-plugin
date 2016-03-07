package com.dyrkin.monkeyc.idea.plugin.psi;

import com.dyrkin.monkeyc.idea.plugin.MonkeyLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MonkeyElementType extends IElementType {
  public MonkeyElementType(@NotNull @NonNls String debugName) {
    super(debugName, MonkeyLanguage.Instance());
  }
}
