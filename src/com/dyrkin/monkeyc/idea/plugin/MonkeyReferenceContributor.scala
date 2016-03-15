package com.dyrkin.monkeyc.idea.plugin

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.{PsiElement, PsiReferenceProvider, PsiReferenceRegistrar, PsiReferenceContributor}
import com.intellij.util.ProcessingContext

/**
  * @author eugene zadyra
  */
class MonkeyReferenceContributor extends PsiReferenceContributor {
  override def registerReferenceProviders(registrar: PsiReferenceRegistrar): Unit = {
//    registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
//                    new PsiReferenceProvider() {
//
//                        override def getReferencesByElement(element: PsiElement,  context: ProcessingContext) {
//                            val literalExpression = element.asInstanceOf[PsiLiteralExpression]
//                            val value = literalExpression.getValue() instanceof String ? (String)literalExpression.getValue() : null;
//                            if (value != null && value.startsWith("simple"+":")) {
//                                return new PsiReference[]{new SimpleReference(element, new TextRange(8, value.length() + 1))};
//                            }
//                            return PsiReference.EMPTY_ARRAY;
//                        }
//                    });
  }
}
