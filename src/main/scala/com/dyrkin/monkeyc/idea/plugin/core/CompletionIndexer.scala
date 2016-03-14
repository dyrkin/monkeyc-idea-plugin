package com.dyrkin.monkeyc.idea.plugin.core

import java.io.File


import com.dyrkin.monkeyc.idea.plugin.module.template.nons.ProjectInfoDomain.Monkeybrains
import com.dyrkin.monkeyc.idea.plugin.module.template.ns.ManifestDomain

import com.dyrkin.monkeyc.idea.plugin.module.template.Marshaller

import scala.language.implicitConversions
import scala.collection.JavaConversions._

object Applic extends App {
  //  val res = new CompletionIndexer().scan("/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5")
  //  res.foreach(r => println(new ClazzTemplate().gen(r._2)))
  ////  println(res)

//  Marshaller.marshall(MonkeyManifest(Application("GymTrackerApp", "2DBC6F79C98B4F8ABB789EA391DCF047"
//    , "@Drawables.LauncherIcon", "@Strings.AppName", "watch-app",
//    Products(List(Product("fenix 3"), Product("D2 Bravo"))),
//    Permissions(List(Permission("perm"))),
//    Languages(List("eng")))), classOf[MonkeyManifest])

  val projectInfo = Marshaller.unmarshall(new File("/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5/bin/projectInfo.xml"), classOf[Monkeybrains])
  println(projectInfo)
}
