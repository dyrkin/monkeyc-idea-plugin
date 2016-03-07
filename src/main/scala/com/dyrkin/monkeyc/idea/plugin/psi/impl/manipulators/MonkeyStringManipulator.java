package com.dyrkin.monkeyc.idea.plugin.psi.impl.manipulators;

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyStringLiteral;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;

import org.jetbrains.annotations.NotNull;

public class MonkeyStringManipulator extends AbstractElementManipulator<MonkeyStringLiteral> {
  @Override
  public MonkeyStringLiteral handleContentChange(@NotNull MonkeyStringLiteral literal, @NotNull TextRange range, String newContent)
      throws IncorrectOperationException {
    final String newText = range.replace(literal.getText(), newContent);
    return (MonkeyStringLiteral)literal.updateText(newText);
  }

  @NotNull
  @Override
  public TextRange getRangeInElement(@NotNull final MonkeyStringLiteral element) {
    return element.getTextLength() > 2 ? TextRange.from(1, element.getTextLength() - 2) : TextRange.EMPTY_RANGE;
  }
}
