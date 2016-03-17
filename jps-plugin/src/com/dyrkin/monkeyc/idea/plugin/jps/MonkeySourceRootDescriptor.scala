package com.dyrkin.monkeyc.idea.plugin.jps

import java.io.{FileFilter, File}

import com.intellij.openapi.util.io.FileUtilRt
import org.jetbrains.jps.builders.{BuildTarget, BuildRootDescriptor}


class MonkeySourceRootDescriptor(root: File, target: MonkeyTarget) extends BuildRootDescriptor {
  override def getRootFile: File = root

  override def getTarget: BuildTarget[_] = target

  override def getRootId: String = root.getAbsolutePath

  override def createFileFilter(): FileFilter = {
    new FileFilter() {
      override def accept(file: File): Boolean = FileUtilRt.extensionEquals(file.getName, "mc")
    }
  }
}
