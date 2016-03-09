package com.dyrkin.monkeyc.idea.plugin.core.helper

/**
  * @author eugene zadyra
  */
trait ModuleKind

object ClazzKind extends ModuleKind

object ModuleKind extends ModuleKind

case class ModuleOrClass(name: String, kind: ModuleKind, modules: Seq[Reference], clazzes: Seq[Reference], constants: Seq[Constant], methods: Seq[Method], isDeprecated: Boolean) {
  def lastComponent = name.split("::").last
}

case class Reference(ref: String)

case class Parameter(name: String, kind: Reference, description: String)

case class Device(name: String)

case class Method(name: String, returns: Reference, params: Seq[Parameter], devices: Seq[Device], since: String, description: String, isConstructor: Boolean)

case class Constant(name: String, value: String, description: String, since: String)
