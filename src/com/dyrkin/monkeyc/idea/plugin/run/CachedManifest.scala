package com.dyrkin.monkeyc.idea.plugin.run

import com.dyrkin.monkeyc.idea.plugin.XmlFile
import com.dyrkin.monkeyc.idea.plugin.module.template.ns.ManifestDomain.MonkeyManifest
import com.intellij.openapi.module.Module
import com.intellij.openapi.vfs.VfsUtilCore
import scala.collection.mutable
import scala.util.Try

/**
  * @author eugene zadyra
  */

object CachedManifest {

  val holder = mutable.Map[Module, mutable.Map[Long, MonkeyManifest]]()

  def apply(module: Module) = {
    //TODO Review module.getModuleFile.getParent
    Try(module.getModuleFile.getParent.findFileByRelativePath("manifest.xml")).map { manifest =>
      val stamp = manifest.getModificationStamp
      holder synchronized {
        if (!holder.contains(module)) {
          holder += module -> mutable.Map()
        }
        if (!holder(module).contains(stamp)) {
          holder(module).clear()
          holder(module) += stamp -> VfsUtilCore.virtualToIoFile(manifest).makeNsObj(classOf[MonkeyManifest])
        }
      }
      holder(module)(stamp)
    }.getOrElse(sys.error("manifest.xml not found in the module root"))
  }
}
