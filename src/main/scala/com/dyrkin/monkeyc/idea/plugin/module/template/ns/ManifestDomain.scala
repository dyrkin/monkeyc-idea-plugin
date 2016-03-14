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
  case class Languages(@xmlElement var language: java.util.List[String])

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Permission(@xmlAttribute var id: String) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Permissions(@xmlElement var permission: java.util.List[Permission]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Product(@xmlAttribute var id: String)

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Products(@xmlElement var product: java.util.List[Product])

  @XmlAccessorType(XmlAccessType.FIELD)
  case class Application(@xmlAttribute var entry: String, @xmlAttribute var id: String,
                         @xmlAttribute var launcherIcon: String, @xmlAttribute var name: String,
                         @xmlAttribute var `type`: String, @xmlElement var products: Products,
                         @xmlElement var permissions: Permissions, @xmlElement var languages: Languages)

  @XmlRootElement(name = "manifest")
  @XmlAccessorType(XmlAccessType.FIELD)
  case class MonkeyManifest(@xmlElement val application: Application) {

    def this() = this(null)
  }

}


