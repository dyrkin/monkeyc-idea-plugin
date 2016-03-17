package com.dyrkin.monkeyc.idea.plugin.sdk

import java.io.File

import com.dyrkin.monkeyc.idea.plugin.common.util.UTIL
import UTIL._


class SdkFiles(homePath: String) {
  private lazy val bin = new File(homePath, "bin").getAbsoluteFile

  def monkeyc = new File(bin, os("monkeyc", ext = ".bat"))

  def shell = new File(bin, os("shell"))

  def connectiq = new File(bin, os("connectiq", ext = ".bat"))
}
