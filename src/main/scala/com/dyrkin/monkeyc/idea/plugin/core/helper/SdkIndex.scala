package com.dyrkin.monkeyc.idea.plugin.core.helper

import com.intellij.openapi.externalSystem.service.execution.InvalidSdkException

/**
  * @author eugene zadyra
  */
object SdkIndex {
  val index = new CompletionIndexer().scan("/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5")

  def getAllSdkUris() = index.keys.map(_.replaceAll("::", "."))

  lazy val sdkFiles = index.map { case (name, c) =>
    (name.replaceAll("::", "."), new ClazzTemplate().gen(c))
  }.toMap
}
