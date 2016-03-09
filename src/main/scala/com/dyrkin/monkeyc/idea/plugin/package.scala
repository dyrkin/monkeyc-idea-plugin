package com.dyrkin.monkeyc.idea

/**
  * @author eugene zadyra
  */
package object plugin {

  implicit class StringUtils(str: String) {
    def cleanup = str.replaceAll("IntellijIdeaRulezzz", "")
    def lastComponent = str.split("\\.").last
  }

}
