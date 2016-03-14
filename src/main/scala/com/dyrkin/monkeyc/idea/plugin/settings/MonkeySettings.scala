package com.dyrkin.monkeyc.idea.plugin.settings

import com.intellij.openapi.components._
import com.intellij.openapi.project.Project

/**
  * @author eugene zadyra
  */

object MonkeySettings {
  def apply(project: Project) = {
    Option(ServiceManager.getService(project, classOf[MonkeySettings])).getOrElse(new MonkeySettings)
  }
}

@State(
  name = "MonkeySettings",
  storages = Array(new Storage(id = "dir", file = StoragePathMacros.APP_CONFIG + "/monkey.xml", scheme = StorageScheme.DIRECTORY_BASED)
  )
)
class MonkeySettings extends PersistentStateComponent[MonkeyOptions] {

  var options: MonkeyOptions = new MonkeyOptions

  override def loadState(mo: MonkeyOptions): Unit = {
    options = mo
  }

  override def getState: MonkeyOptions = options

  def projectType = options.projectType

  def targetPlatforms = options.targetPlatforms

  def langs = options.langs

  def setProjectType(projectType: String): Unit = {
    options.projectType = projectType
  }

  def setTargetPlatforms(targetPlatforms: Array[String]): Unit = {
    options.targetPlatforms = targetPlatforms
  }

  def setLangs(langs: Array[String]): Unit = {
    options.langs = langs
  }
}

class MonkeyOptions {
  var projectType: String = _
  var targetPlatforms: Array[String] = _
  var langs: Array[String] = _
}
