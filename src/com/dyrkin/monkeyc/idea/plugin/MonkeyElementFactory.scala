package com.dyrkin.monkeyc.idea.plugin

import com.dyrkin.monkeyc.idea.plugin.psi.MonkeyId
import com.intellij.openapi.project.Project
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiFile, PsiFileFactory}


object MonkeyElementFactory {

  def createIdentifierFromText(project: Project, text: String) = {
    val dummyFile = createDummyFile(project, s"var $text;")
    PsiTreeUtil.findChildOfType(dummyFile, classOf[MonkeyId])
  }

  private def createDummyFile(myProject: Project, content: String): PsiFile = {
    val factory = PsiFileFactory.getInstance(myProject)
    val name = "dummy." + MonkeyFileType().getDefaultExtension()
    factory.createFileFromText(name, MonkeyLanguage(), content)
  }
}
