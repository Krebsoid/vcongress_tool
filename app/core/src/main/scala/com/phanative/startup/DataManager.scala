package com.phanative.startup

import data.{DataEntity, DataService, Data}
import javax.enterprise.inject.Instance
import javax.inject.Inject
import scala.collection.JavaConversions._
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DataManager {

  @Inject
  var data: Instance[Data] = _

  @Inject
  var service: DataService = _

  def execute() {
    val sortedData = data
      .iterator()
      .toList
      .sortBy((data: Data) => data.index())

    sortedData.foreach((data: Data) => {

      val findResult: Option[DataEntity] = service.find(data.name())

      val entity: DataEntity = findResult.getOrElse({
        val newEntity = new DataEntity
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