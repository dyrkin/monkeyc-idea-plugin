package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.core.helper.CompletionIndexer
import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes
import com.intellij.codeInsight.completion._
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns._
import com.intellij.util.ProcessingContext


class MonkeyCompletionContributor extends CompletionContributor {
  val sdk = new CompletionIndexer().scan("/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5")
  println("Contributor initialized")

  extend(CompletionType.BASIC, psiElement(MonkeyTypes.IDENTIFIER).withLanguage(MonkeyLanguage()),
    new CompletionProvider[CompletionParameters]() {
      def addCompletions(parameters: CompletionParameters,
                         context: ProcessingContext,
                         resultSet: CompletionResultSet) {
        resultSet.addElement(LookupElementBuilder.create("Hello"))
        println("Completion")
      }
    }
  )


//  extend(CompletionType.BASIC,
//    psiElement(MonkeyTypes.IDENTIFIER)
//      .withSuperParent(4, psiElement(MonkeyTypes.USING_REFERENCE).withoutText("Toybox"))
//      .withLanguage(MonkeyLanguage()),
//    new CompletionProvider[CompletionParameters]() {
//      def addCompletions(parameters: CompletionParameters,
//                         context: ProcessingContext,
//                         resultSet: CompletionResultSet) {
//        resultSet.addElement(LookupElementBuilder.create("Toybox"))
//      }
//    }
//  )
}
