package com.phanative.model.core.person

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence.{ManyToOne, Entity}

@Entity
class Address extends AbstractEntity {
  var street: String = ""
  var zipCode: String = ""
  var city: String = ""

  @ManyToOne
  var country: Country = _
}