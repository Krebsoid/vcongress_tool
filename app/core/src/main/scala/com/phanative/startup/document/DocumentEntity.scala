package com.phanative.startup.document

import javax.persistence.{GeneratedValue, Id, Entity}

@Entity
class DocumentEntity {

  @Id
  @GeneratedValue
  var id: Long = _

  var path: String = _
  var name: String = _

  var data : Array[Byte] = _

  var locale : String = _

}