package com.phanative.startup

import javax.inject.Inject
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Instance
import scala.collection.JavaConversions._
import scenario.{ScenarioEntity, ScenarioService, Scenario}

/**
 * @author: Patrick Bittner
 */
@ApplicationScoped
class ScenarioManager {

  @Inject
  var data: Instance[Scenario] = _

  @Inject
  var service: ScenarioService = _

  def execute() {
    val sortedData = data
      .iterator()
      .toList
      .sortBy((scenario: Scenario) => scenario.index())

    sortedData.foreach((scenario: Scenario) => {

      val findResult: Option[ScenarioEntity] = service.find(scenario.name())

      val entity: ScenarioEntity = findResult.getOrElse({
        val newEntity = new ScenarioEntity
        newEntity.name = scenario.name()
        newEntity.loaded = false
        newEntity
      })

      if (!entity.loaded) {
        scenario.initialize()
        entity.loaded = true
        service.save(entity)
      }
    })
  }

}