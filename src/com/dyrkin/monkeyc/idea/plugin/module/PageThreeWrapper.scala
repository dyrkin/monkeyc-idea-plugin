package com.dyrkin.monkeyc.idea.plugin.module


class PageThreeWrapper {
  val page = new PageThree

  def setTemplates(templates: List[String]): Unit = {
    page.template.removeAllItems()
    templates.foreach(t => page.template.addItem(t))
  }

  def template = page.template.getSelectedItem.asInstanceOf[String]
}
