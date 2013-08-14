package com.phanative.module.security.model.identity

import javax.persistence.ManyToOne

trait ManyToIdentity {

  @ManyToOne(optional = false)
  var identity : IdentityObject = _

}