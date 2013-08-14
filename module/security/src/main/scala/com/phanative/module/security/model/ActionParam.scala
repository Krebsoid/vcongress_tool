package com.phanative.module.security.model

import javax.persistence.Entity
import com.phanative.module.persistence.model.AbstractEntity

@Entity
class ActionParam extends AbstractEntity{

  var name : String = _

  var value: String = _

}
