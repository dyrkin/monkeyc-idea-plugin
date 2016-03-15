package com.dyrkin.monkeyc.idea.plugin.module.template.ns

import javax.xml.bind.annotation._

import scala.annotation.meta.field

/**
  * @author eugene zadyra
  */

object ManifestDomain {
  type xmlAttribute = XmlAttribute@field
  type xmlElement = XmlElement@field


  @XmlAccessorType(XmlAccessType.FIELD)
  case class Languages(@xmlElement language: java.util.List[String]){
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Permission(@xmlAttribute id: String) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Permissions(@xmlElement permission: java.util.List[Permission]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Product(@xmlAttribute id: String){
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Products(@xmlElement product: java.util.List[Product]){
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Application(@xmlAttribute entry: String, @xmlAttribute id: String,
                         @xmlAttribute launcherIcon: String, @xmlAttribute name: String,
                         @xmlAttribute `type`: String, @xmlElement products: Products,
                         @xmlElement permissions: Permissions, @xmlElement languages: Languages) {
    def this() = this(null, null, null, null, null, null, null, null)
  }

  @XmlRootElement(name = "manifest")
  @XmlAccessorType(XmlAccessType.FIELD)
  case class MonkeyManifest(@xmlElement val application: Application) {
    def this() = this(null)
  }

}


