package com.dyrkin.monkeyc.idea.plugin.core.helper

import java.io.File

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import scala.collection.JavaConversions._


class CompletionIndexer {

  def scan(sdk: String): Map[String, ModuleOrClass] = {

    val doc = new File(sdk, "doc")
    val toyboxFolder = new File(doc.getAbsolutePath, "Toybox")
    val toyboxHtml = new File(doc.getAbsolutePath, "Toybox.html")

    val htmls = toyboxFolder.find("html") :+ toyboxHtml

    htmls.map { file =>
      val xml = Jsoup.parse(file, "UTF-8", "http://localhost/")

      val Array(kind, referenceDep) = xml.select("div[id=content] h1").get(0).text().trim.split(":\\s+")
      val (name, deprecated) = referenceDep.split("\\s+") match {
        case Array(ref, dep) => (ref, true)
        case Array(ref) => (ref, false)
      }
      val constants = xml.select("dl.constants dt").map { cd =>
        val Array(name, value) = cd.toString.split("\n")(1).trim.split("\\s*=\\s*")
        val description = extractDescription(cd)
        val since = cd.select("ul.since").get(0).text().trim.removeTags.removeSpaces
        Constant(name, value, description, since)
      }
      val classes = xml.select("p.children span.object_link a[title~=(class)]").map { c =>
        val classRef = c.attr("title").replaceAll("\\s+\\(class\\)", "")
        Reference(classRef)
      }

      val modules = xml.select("p.children span.object_link a[title~=(module)]").map { c =>
        val moduleRef = c.attr("title").replaceAll("\\s+\\(module\\)", "").trim
        Reference(moduleRef)
      }

      val methods = xml.select("div.method_details").map { m =>
        val returns = Reference(extractType(m, "h3.signature"))
        val name = m.select("h3.signature strong").first().text()
        val params = m.select("ul.param li") map { p =>
          val paramName = p.select("span.name").first().text()
          val paramType = extractType(p, "span.type")
          val description = p.select("p").first() map (_.text()) getOrElse ""
          Parameter(paramName, Reference(paramType), description)
        }
        val description = extractDescription(m)
        val devices = m.select("ul.supported p").map(d => Device(d.text().trim))

        val since = m.select("ul.since").first() map (_.text().trim.removeTags.removeSpaces) getOrElse "1.0.0"
        Method(name, returns, params, devices, since, description, name == "initialize")
      }
      name -> ModuleOrClass(name, if (kind == "Class") ClazzKind else ModuleKind, modules, classes, constants, methods, deprecated)
    }.toMap

  }

  def extractDescription(m: Element) = {
    m.select("div[class=discussion]").first() map (_.text().trim.removeTags) getOrElse ""
  }

  def extractType(m: Element, root: String) = {
    val preReturns = m.select(s"$root tt span[class=object_link] a[title~=(class)]").last() getOrElse m.select(s"$root tt span[class=object_link] a[title~=(module)]").last() getOrElse m.select(s"$root tt").first() getOrElse m.select(root).first()
    if (preReturns.hasAttr("title")) {
      if (preReturns.attr("title").contains("(class)"))
        preReturns.attr("title").replaceAll("\\s+\\(class\\)", "").trim
      else "Toybox::Graphics::Dc"
    }
    else "Toybox::Lang::" + preReturns.text().replaceAll("[\\(\\)]", "").trim
  }

}
