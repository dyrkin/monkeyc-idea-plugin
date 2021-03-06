package com.dyrkin.monkeyc.idea.plugin

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory}


class MonkeyFileTypeFactory extends FileTypeFactory {
  override def createFileTypes(fileTypeConsumer: FileTypeConsumer): Unit = {
    fileTypeConsumer.consume(MonkeyFileType(), "mc")
  }
}
