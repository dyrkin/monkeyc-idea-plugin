package com.dyrkin.monkeyc.idea.plugin.module


class PageOneWrapper {
  val page = new PageOne

  val AppTypes = Map[AnyRef, String]("Watch Face" -> "watchface", "Data Field" -> "datafield", "Widget" -> "widget", "Watch App" -> "watch-app")

  def applicationType = AppTypes(page.projectType.getSelectedItem)

  def targetPlatforms = {
    List(
      "square_watch" -> page.squareWatch.isSelected,
      "tall_watch" -> page.tallWatch.isSelected,
      "round_watch" -> page.roundWatch.isSelected,
      "semi_round_watch" -> page.semiRoundWatch.isSelected,
      "fr630" -> page.forerunner630.isSelected,
      "fr235" -> page.forerunner235.isSelected,
      "fr230" -> page.forerunner230.isSelected,
      "vivoactive" -> page.vivoactive.isSelected,
      "fenix3" -> page.fenix3.isSelected,
      "fenix3_hr" -> page.fenix3hr.isSelected,
      "d2bravo" -> page.d2Bravo.isSelected,
      "920XT" -> page.forerunner920.isSelected,
      "vivoactive_hr" -> page.vivoactiveHr.isSelected
    ).filter(_._2).map(_._1)
  }
}
