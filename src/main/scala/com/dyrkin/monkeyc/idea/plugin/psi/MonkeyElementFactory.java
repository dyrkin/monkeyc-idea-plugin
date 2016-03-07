package com.dyrkin.monkeyc.idea.plugin.psi;

import com.dyrkin.monkeyc.idea.plugin.MonkeyFile;
import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class MonkeyElementFactory {

  public static MonkeyNamedElement createProperty(Project project, String name) {

    final MonkeyFile file = createFile(project, name);
    return (MonkeyNamedElement) file.getFirstChild();
  }

  public static MonkeyFile createFile(Project project, String text) {
    String name = "dummy.mc";
    return (MonkeyFile) PsiFileFactory.getInstance(project).
        createFileFromText(name, MonkeyFileType.Instance(), text);
  }
}
