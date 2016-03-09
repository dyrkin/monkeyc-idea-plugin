package com.dyrkin.monkeyc.idea.plugin.core

import com.dyrkin.monkeyc.idea.plugin.core.helper.{ClazzTemplate, CompletionIndexer}

import scala.language.implicitConversions



object Applic extends App {
  val res = new CompletionIndexer().scan("/Volumes/Data/Users/unkind/Documents/j2ee/software/garmin/connectiq-sdk-mac-1.2.5")
  res.foreach(r => println(new ClazzTemplate().gen(r._2)))
//  println(res)
}
