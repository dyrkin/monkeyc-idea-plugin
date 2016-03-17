package com.dyrkin.monkeyc.idea.plugin.core

import java.io.File


package object helper {
  implicit class Directory(file: File) {
    def find(extensions: String*) = {
      def find(f: File): Array[File] = {
        val these = f.listFiles
        these ++ these.filter(_.isDirectory).flatMap(find)
      }
      find(file).filter(f => extensions.exists(ext => f.getName.endsWith(s".$ext")))
    }

    def empty(): Unit = {
      def empty(f: File): Unit = {
        val these = f.listFiles
        these.filterNot(_.isDirectory).foreach(_.delete())
        these.filter(_.isDirectory).foreach(empty)
      }

      if (file.exists()) {
        empty(file)
        file.delete()
      }
    }
  }

  implicit class RichString(str: String) {
    def removeTags = str.replaceAll("</p>", "\n").replaceAll("<.+?>", "")

    def removeSpaces = str.replaceAll("\\s+", "")
  }

  implicit def any2Opt[T](any: T): Option[T] = Option(any)

}
