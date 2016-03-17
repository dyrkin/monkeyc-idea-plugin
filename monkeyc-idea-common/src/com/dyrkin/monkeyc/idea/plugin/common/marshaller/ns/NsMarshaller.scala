package com.dyrkin.monkeyc.idea.plugin.common.marshaller.ns

import java.io.{File, StringWriter}
import javax.xml.bind.JAXBContext

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper

/**
  * @author eugene zadyra
  */
object NsMarshaller {

  val prefixMapper = new NamespacePrefixMapper {
    override def getPreferredPrefix(namespaceUri: String, suggestion: String, requirePrefix: Boolean): String = "iq"
  }

  def marshall(ref: AnyRef, clazz: Class[_]): String = {
    val jc = JAXBContext.newInstance(clazz)

    val marshaller = jc.createMarshaller()
    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true)
    marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", prefixMapper)
    val writer = new StringWriter()
    marshaller.marshal(ref, writer)
    writer.toString
  }

  def unmarshall[T](file: File, clazz: Class[T]): T = {
    val jc = JAXBContext.newInstance(clazz)
    val unmarshaller = jc.createUnmarshaller()
    unmarshaller.unmarshal(file).asInstanceOf[T]
  }
}
