package com.dyrkin.monkeyc.idea.plugin

import com.intellij.openapi.fileTypes.{FileType, SyntaxHighlighter, SyntaxHighlighterFactory, SyntaxHighlighterProvider}
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


class MonkeySyntaxHighlighterFactory extends SyntaxHighlighterFactory with SyntaxHighlighterProvider {
  override def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter = new MonkeySyntaxHighlighter

  override def create(fileType: FileType, project: Project, virtualFile: VirtualFile): SyntaxHighlighter = new MonkeySyntaxHighlighter
}
