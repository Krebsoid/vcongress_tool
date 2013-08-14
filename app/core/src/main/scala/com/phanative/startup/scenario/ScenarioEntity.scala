package com.phanative.startup.scenario

import javax.persistence.{GeneratedValue, Id, Column, Entity}

@Entity
class ScenarioEntity {

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(name = "classname", unique=true)
  var name : String = _

  var loaded : Boolean = _

}