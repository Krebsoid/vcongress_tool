package com.phanative.model.core.person

import javax.persistence.ManyToOne

trait ManyToPerson  {

  @ManyToOne(optional = false)
  var person: Person = _


}