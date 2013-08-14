package com.phanative.model.core.person

import com.phanative.module.persistence.model.{LocaleString, AbstractEntity}
import javax.persistence.{CascadeType, OneToOne, Entity}
import scala.Array

@Entity
class Country extends AbstractEntity {

  var isoCode: String = ""

  @OneToOne(cascade = Array(CascadeType.ALL))
  var name: LocaleString = new LocaleString()

}