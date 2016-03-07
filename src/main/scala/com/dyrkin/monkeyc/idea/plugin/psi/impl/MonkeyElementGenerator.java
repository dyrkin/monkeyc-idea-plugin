package com.dyrkin.monkeyc.idea.plugin.psi.impl;

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType;
import com.dyrkin.monkeyc.idea.plugin.MonkeyLanguage;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyComponent;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyComponentName;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyId;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.impl.PsiFileFactoryImpl;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.LightVirtualFile;

import org.jetbrains.annotations.Nullable;

public class MonkeyElementGenerator {
  @Nullable
  public static MonkeyId createIdentifierFromText(Project myProject, String name) {
    final PsiFile dummyFile = createDummyFile(myProject, "function " + name + "(){}");

    final MonkeyComponent monkeyComponent = PsiTreeUtil.getChildOfType(dummyFile, MonkeyComponent.class);
    //final MonkeyComponent monkeyComponent = PsiTreeUtil.getChildOfType(dummyFile, MonkeyComponent.class);
    final MonkeyComponentName componentName = monkeyComponent == null ? null : monkeyComponent.getComponentName();
    return componentName == null ? null : componentName.getId();
  }

  public static PsiFile createDummyFile(Project myProject, String text) {
    final PsiFileFactory factory = PsiFileFactory.getInstance(myProject);
    final String name = "dummy." + MonkeyFileType.Instance().getDefaultExtension();
    final LightVirtualFile virtualFile = new LightVirtualFile(name, MonkeyFileType.Instance(), text);
    final PsiFile psiFile = ((PsiFileFactoryImpl) factory).trySetupPsiForFile(virtualFile, MonkeyLanguage.Instance(), false, true);
    assert psiFile != null;
    return psiFile;
  }
}
