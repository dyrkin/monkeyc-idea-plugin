package com.dyrkin.monkeyc.idea.plugin.module


class PageTwoWrapper {
  val page = new PageTwo

  def selectedLanguages = List(
    "eng" -> page.eng.isSelected
  ).filter(_._2).map(_._1)
}
