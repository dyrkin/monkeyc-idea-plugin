package com.dyrkin.monkeyc.idea.plugin.vfs

import java.util.Date

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Computable
import com.intellij.openapi.vfs.{VfsUtil, VirtualFile}
import com.intellij.psi.{PsiManager, PsiElement, PsiFileFactory}

/**
  * @author eugene zadyra
  */
object Vfs {
  def saveFile(project: Project, name: String, dir: VirtualFile, content: String) = {

    val factory = PsiFileFactory.getInstance(project)
    val file = factory.createFileFromText(name, MonkeyFileType(), content, new Date().getTime, true)
//    val psiParent = PsiManager.getInstance(project).findDirectory(dir)

    val fileDocumentManager = FileDocumentManager.getInstance()
    val document = fileDocumentManager.getDocument(file.getVirtualFile)
    if (document != null) {
      fileDocumentManager.saveDocument(document)
    }

//    ApplicationManager.getApplication.runWriteAction(
//      new Computable[PsiElement]() {
//        override def compute(): PsiElement = {
//
//          null
//        }
//      }
//    )
  }
}
