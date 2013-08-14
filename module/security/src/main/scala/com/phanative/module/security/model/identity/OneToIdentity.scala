package com.phanative.module.security.model.identity

import javax.persistence.OneToOne

trait OneToIdentity {

  @OneToOne(optional = false)
  var identity : IdentityObject = _

}