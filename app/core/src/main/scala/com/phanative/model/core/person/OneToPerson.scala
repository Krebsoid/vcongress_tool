package com.phanative.model.core.person

import javax.persistence.OneToOne

trait OneToPerson {

  @OneToOne(optional = false)
  var person : Person = _


}