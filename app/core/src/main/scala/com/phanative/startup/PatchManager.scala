package com.phanative.startup

import javax.enterprise.inject.Instance
import javax.inject.Inject
import patch.{PatchEntity, PatchService, Patch}
import scala.collection.JavaConversions._
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PatchManager {

  @Inject
  var data: Instance[Patch] = _

  @Inject
  var service: PatchService = _

  def execute() {
    val sortedData = data
      .iterator()
      .toList
      .sortBy((data: Patch) => data.index())

    sortedData.foreach((data: Patch) => {

      val findResult: Option[PatchEntity] = service.find(data.name())

      val entity: PatchEntity = findResult.getOrElse({
        val newEntity = new PatchEntity
        newEntity.name = data.name()
        newEntity.loaded = false
        newEntity
      })

      if (!entity.loaded) {
        data.initialize()
        entity.loaded = true
        service.save(entity)
      }
    })
  }


}