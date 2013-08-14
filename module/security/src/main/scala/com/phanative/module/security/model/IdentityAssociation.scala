package com.phanative.module.security.model

import javax.persistence.Column
import com.phanative.module.persistence.model.AbstractEntity

trait IdentityAssociation extends AbstractEntity{

  @Column(unique = true, nullable = false)
  var name: String = _

}