package com.dyrkin.monkeyc.idea.plugin.core.helper

import java.io.{InputStreamReader, StringReader, StringWriter}

import org.apache.velocity.{Template, VelocityContext}
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.{RuntimeSingleton, RuntimeConstants}
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader

import scala.collection.JavaConversions._



trait VmTemplate {
  def gen(moc: ModuleOrClass): String
}

object VmUtil {
  def asJava[T](scalaSeq: Seq[T]): java.util.Collection[T] = {
    asJavaCollection(scalaSeq)
  }

  def makeParamsList(params: Seq[Parameter]) = {
    params.map(p => p.name).mkString(", ")
  }
}

class ClazzTemplate extends VmTemplate {

  val engine = new VelocityEngine()
  engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
  engine.setProperty("classpath.resource.loader.class", classOf[ClasspathResourceLoader].getName)
  engine.init()


  override def gen(moc: ModuleOrClass) = {
    val runtimeServices = RuntimeSingleton.getRuntimeServices
    val reader = new InputStreamReader(this.getClass.getResourceAsStream("/templates/class.vm"))
    val node = runtimeServices.parse(reader, "Template name")
    val template = new Template()
    template.setRuntimeServices(runtimeServices)
    template.setData(node)
    template.initDocument()
//    val template = engine.get this.getClass.getResourceAsStream("templates/class.vm")
    val context = new VelocityContext()
    context.put("c", VmUtil)
    context.put("moc", moc)
    val writer = new StringWriter()
    template.merge(context, writer)
    writer.toString
  }
}

class ModuleTemplate(moc: ModuleOrClass) extends VmTemplate {
  override def gen(moc: ModuleOrClass) = {
    ""
  }
}
