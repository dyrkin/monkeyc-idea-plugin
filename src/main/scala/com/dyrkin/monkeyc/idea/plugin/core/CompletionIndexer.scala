package com.dyrkin.monkeyc.idea.plugin.core

import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.{XPathConstants, XPathFactory}

import org.jsoup.Jsoup

import scala.xml._

/**
  * @author eugene zadyra
  */
class CompletionIndexer {

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

  case class Module(name: String, clazzes: List[Clazz])

  case class Clazz(name: String)

  val connectIdSdk = "/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5"
  val doc = new File(connectIdSdk, "doc")
  val toyboxFolder = new File(doc.getAbsolutePath, "Toybox")
  val toyboxHtml = new File(doc.getAbsolutePath, "Toybox.html")

  def scan(folder: File): Unit = {
    val htmls = folder.find("html") :+ toyboxHtml

    htmls.foreach { file =>
      val xml = Jsoup.parse(file, "UTF-8", "http://localoch/")

      println(xml.select("div[id=content] h1").get(0).text())
      println(xml.select("dl[class=constants] dt"))
    }
  }

  scan(toyboxFolder)
}

object Applic extends App {
  new CompletionIndexer()
}
