package com.dyrkin.monkeyc.idea.plugin.facet

import com.dyrkin.monkeyc.idea.plugin.MonkeyFileType
import com.dyrkin.monkeyc.idea.plugin.common.MonkeyConstants
import com.intellij.facet.FacetType
import com.intellij.framework.detection.{FileContentPattern, FacetBasedFrameworkDetector}
import com.intellij.openapi.fileTypes.FileType
import com.intellij.patterns.ElementPattern
import com.intellij.util.indexing.FileContent

/**
  * @author eugene zadyra
  */
object MonkeyFacetBasedFrameworkDetector {
  val DetectorId = MonkeyConstants.FacetTypeName
}

class MonkeyFacetBasedFrameworkDetector extends FacetBasedFrameworkDetector[MonkeyFacet, MonkeyFacetConfiguration](MonkeyFacetBasedFrameworkDetector.DetectorId) {
  override def getFacetType: FacetType[MonkeyFacet, MonkeyFacetConfiguration] = FacetType.findInstance(classOf[MonkeyFacetType])

  override def getFileType: FileType = MonkeyFileType()

  override def createSuitableFilePattern(): ElementPattern[FileContent] = FileContentPattern.fileContent()
}
