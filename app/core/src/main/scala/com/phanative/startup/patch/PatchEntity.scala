package com.phanative.startup.patch

import javax.persistence.{GeneratedValue, Id, Column, Entity}

@Entity
class PatchEntity {

  @Id
  @GeneratedValue
  var id: Long = _

  @Column(name = "classname", unique=true)
  var name : String = _

  var loaded : Boolean = _

}