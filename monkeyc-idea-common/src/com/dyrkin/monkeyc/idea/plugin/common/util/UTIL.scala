package com.dyrkin.monkeyc.idea.plugin.common.util

import java.io.File
import java.util.UUID
import com.dyrkin.monkeyc.idea.plugin.common.marshaller.nons.NonsMarshaller
import com.dyrkin.monkeyc.idea.plugin.common.marshaller.ns.NsMarshaller
import org.jsoup.Jsoup


object UTIL {
  //String utils
  implicit class StringUtils(str: String) {
    def cleanup = str.replaceAll("IntellijIdeaRulezzz", "")

    def lastComponent = str.split("\\.").last
  }

  //OS Utils
  def isWin = sys.props("os.name").toLowerCase().contains("win")

  def os(unixName: String, ext: String = ".exe", winName: Option[String] = None) = {
    if (isWin) winName getOrElse s"$unixName$ext" else unixName
  }

  //JSOUP Utils
  implicit class JSoupFile(file: File) {
    def html = Jsoup.parse(file, "UTF-8", "http://localhost/")
  }

  def genId = {
    val uuid = UUID.randomUUID
    String.format("%016X%016X", uuid.getMostSignificantBits.asInstanceOf[AnyRef], uuid.getLeastSignificantBits.asInstanceOf[AnyRef])
  }

  implicit class XmlFile(file: File) {
    def makeNonsObj[T](clazz: Class[T]): T = {
      NonsMarshaller.unmarshall(file, clazz)
    }

    def makeNsObj[T](clazz: Class[T]): T = {
      NsMarshaller.unmarshall(file, clazz)
    }
  }
}
