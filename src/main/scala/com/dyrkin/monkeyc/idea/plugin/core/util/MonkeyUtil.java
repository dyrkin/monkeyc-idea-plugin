package com.dyrkin.monkeyc.idea.plugin.core.util;

import com.dyrkin.monkeyc.idea.plugin.MonkeyFile;
import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyNamedElement;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyReference;
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyReferenceExpression;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.XmlFile;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.DomManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.*;

public class MonkeyUtil {

  public static List<MonkeyNamedElement> findReferences(Project project, MonkeyReference monkeyReference) {
    final MonkeyReferenceExpression referenceExpression = (MonkeyReferenceExpression) monkeyReference;

    final String name = referenceExpression.getComponentName().getName();
    if (name == null) {
      return new ArrayList<>();
    }
    List<MonkeyNamedElement> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MonkeyFileType.Instance(),
        GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      MonkeyFile monkeyFile = (MonkeyFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (monkeyFile != null) {
        MonkeyNamedElement[] references = PsiTreeUtil.getChildrenOfType(monkeyFile.getFirstChild(), MonkeyNamedElement.class);
        if (references != null) {
          for (MonkeyNamedElement reference : references) {
            if (name.equals(reference.getName())) {
              result.add(reference);
            }
          }

          //Collections.addAll(result, references);
        }
      }
    }
    return result;
  }


  private static final Set<String> keywords = ContainerUtil.immutableSet(
      "and", "as", "class", "const", "do", "else", "enum", "extends", "false", "for", "function", "has", "hidden",
      "if", "instanceof", "module", "native", "new", "null", "or", "return", "static", "true", "using", "var", "while");

  public static Set<String> getKeywords() {
    return keywords;
  }

  public static boolean isRealDevice(String deviceId) {
    return !deviceId.equalsIgnoreCase("round_watch") &&
        !deviceId.equalsIgnoreCase("square_watch") &&
        !deviceId.equalsIgnoreCase("semi_round_watch");
  }

  public static String generateProjectId() {
    UUID id = UUID.randomUUID();
    return String.format("%016X%016X", id.getMostSignificantBits(), id.getLeastSignificantBits());
  }

  public static VirtualFile createChildDirectoryIfNotExist(Project project, VirtualFile parent, String name) throws IOException {
    final VirtualFile child = parent.findChild(name);
    return child == null ? parent.createChildDirectory(project, name) : child;
  }


  @Nullable
  public static <T extends DomElement> T loadDomElement(@NotNull final Project project,
                                                        @NotNull final VirtualFile file,
                                                        @NotNull final Class<T> aClass) {
    return ApplicationManager.getApplication().runReadAction(new Computable<T>() {
      @Override
      @Nullable
      public T compute() {
        if (project.isDisposed()) return null;
        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        if (psiFile instanceof XmlFile) {
          return loadDomElementWithReadPermission(project, (XmlFile) psiFile, aClass);
        } else {
          return null;
        }
      }
    });
  }

  /**
   * This method should be called under a read action.
   */
  @Nullable
  public static <T extends DomElement> T loadDomElementWithReadPermission(@NotNull Project project,
                                                                          @NotNull XmlFile xmlFile,
                                                                          @NotNull Class<T> aClass) {
    ApplicationManager.getApplication().assertReadAccessAllowed();
    DomManager domManager = DomManager.getDomManager(project);
    DomFileElement<T> element = domManager.getFileElement(xmlFile, aClass);
    if (element == null) return null;
    return element.getRootElement();
  }
}
