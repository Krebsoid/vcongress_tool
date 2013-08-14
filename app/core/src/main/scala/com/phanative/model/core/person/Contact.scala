package com.phanative.model.core.person

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence.Entity

@Entity
class Contact extends AbstractEntity {
  var email: String = ""
  var phone: String = ""
  var fax: String = ""
}