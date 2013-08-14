package com.phanative.model.core.person

import javax.persistence.Entity
import com.phanative.module.persistence.model.AbstractEntity

@Entity
class Occupation extends AbstractEntity {
  var institute: String = ""
  var department: String = ""
  var position: String = ""
}