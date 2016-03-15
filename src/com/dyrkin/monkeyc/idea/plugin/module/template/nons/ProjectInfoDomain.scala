package com.dyrkin.monkeyc.idea.plugin.module.template.nons

import javax.xml.bind.annotation._

import com.dyrkin.monkeyc.idea.plugin.module.template.ns.ManifestDomain.Permissions

import scala.annotation.meta.field

/**
  * @author eugene zadyra
  */

object ProjectInfoDomain {
  type xmlAttribute = XmlAttribute@field
  type xmlElement = XmlElement@field
  type xmlValue = XmlValue@field

  type JList[T] = java.util.List[T]

  @XmlAccessorType(XmlAccessType.FIELD)
  case class AppPermission(@xmlAttribute id: String, @xmlAttribute name: String, @xmlAttribute description: String, @xmlAttribute module: String) {
    def this() = this(null, null, null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class AppPermissions(@xmlElement permission: JList[AppPermission]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class AppType(@xmlAttribute id: String, @xmlAttribute value: String, @xmlAttribute name: String, @xmlAttribute description: String) {
    def this() = this(null, null, null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class AppTypes(@xmlElement appType: JList[AppType]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class File(@xmlAttribute `type`: String, @xmlValue path: String) {
    def this() = this(null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class NewProjectFileMap(@xmlAttribute appType: String, @xmlAttribute name: String, @xmlAttribute baseDir: String, file: JList[File]) {
    def this() = this(null, null, null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class NewProjectFilesMaps(@xmlElement newProjectFileMap: JList[NewProjectFileMap]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class PermissionMap(@xmlAttribute appType: String, @xmlElement permissions: Permissions) {
    def this() = this(null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class PermissionMaps(@xmlElement permissionMap: JList[PermissionMap]) {
    def this() = this(null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class PlaceHolder(@xmlAttribute sanitized: Boolean, @xmlAttribute suffix: String, @xmlValue value: String) {
    def this() = this(true, null, null)
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  case class NewProjectFilePlaceholders(@xmlElement placeHolder: JList[PlaceHolder]) {
    def this() = this(null)
  }

  @XmlRootElement(name = "monkeybrains")
  @XmlAccessorType(XmlAccessType.FIELD)
  case class ProjectInfo(@xmlElement appPermissions: AppPermissions, @xmlElement permissionMaps: PermissionMaps, @xmlElement appTypes: AppTypes, @xmlElement newProjectFilePlaceholders: NewProjectFilePlaceholders, @xmlElement newProjectFilesMaps: NewProjectFilesMaps) {
    def this() = this(null, null, null, null, null)
  }

}


