package com.phanative.startup.data

import javax.persistence.{GeneratedValue, Id, Column, Entity}

@Entity
class DataEntity {

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(name = "classname", unique=true)
  var name : String = _

  var loaded : Boolean = _

}