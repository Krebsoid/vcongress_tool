package com.phanative.model.core.person

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence.Entity

@Entity
class BillAddress extends Address with AbstractEntity {

  var fullName: String = _
  var institute: String = _

}