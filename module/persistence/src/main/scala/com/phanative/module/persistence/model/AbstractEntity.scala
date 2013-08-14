package com.phanative.module.persistence.model

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Version
import java.lang._

trait AbstractEntity {

  @Id
  @GeneratedValue
  var id: Long = _

  @Version
  var version: Integer = _

}

