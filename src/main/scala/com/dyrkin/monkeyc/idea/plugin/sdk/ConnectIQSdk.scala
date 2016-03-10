package com.dyrkin.monkeyc.idea.plugin.sdk

import java.io.File
import javax.swing.Icon

import com.dyrkin.monkeyc.idea.plugin
import com.dyrkin.monkeyc.idea.plugin._
import com.intellij.openapi.projectRoots._
import org.jdom.Element

import scala.collection.JavaConversions._

/**
  * @author eugene zadyra
  */
object ConnectIQSdk {
  def apply() = SdkType.findInstance(classOf[ConnectIQSdk])
}

class ConnectIQSdk extends SdkType("Connect IQ SDK") {


  override def suggestSdkName(currentSdkName: String, sdkPath: String): String = {
    s"Connect IQ ${extractSdkVersion(sdkPath)}"
  }

  override def createAdditionalDataConfigurable(sdkModel: SdkModel, sdkModificator: SdkModificator): AdditionalDataConfigurable = null

  override def isValidSdkHome(homePath: String): Boolean = {
    val bin = new File(homePath, "bin").getAbsoluteFile
    val monkeyc = new File(bin, os("monkeyc", ext = ".bat"))
    val shell = new File(bin, os("shell"))
    val connectiq = new File(bin, os("connectiq", ext = ".bat"))

    monkeyc.exists() && shell.exists() && connectiq.exists()
  }

  override def getPresentableName: String = "Connect IQ SDK"

  override def suggestHomePath(): String = null

  override def saveAdditionalData(sdkAdditionalData: SdkAdditionalData, element: Element): Unit = {}

  override def getIcon: Icon = MonkeyIcons.Sdk

  override def getIconForAddAction: Icon = MonkeyIcons.Add_Sdk

  override def getVersionString(sdkHome: String): String = {
    extractSdkVersion(sdkHome)
  }

  val VersionRegexp = ".*(\\d+\\.\\d+\\.\\d+).*".r

  //Extract version from README.html
  private def extractSdkVersion(sdkHome: String): String = {
    val readme = new File(sdkHome, "README.html")
    readme.html.select("div[id=tagline]").headOption.map { e =>
      e.text() match {
        case VersionRegexp(version) => version
        case _ => "1.0.0"
      }
    }.getOrElse("1.0.0")
  }
}
