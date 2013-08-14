package com.phanative.module.security.model

import com.phanative.module.persistence.model.AbstractEntity
import java.util._
import javax.persistence.{CascadeType, OneToMany, Entity}
import org.joda.time.LocalDate

@Entity
class RecognizedAction extends AbstractEntity{

  var username: String = _

  var ip: String = _

  var occurDate: LocalDate = new LocalDate()

  var resource: String = _

  var action: String = _

  @OneToMany(cascade = Array(CascadeType.ALL))
  var params: Set[ActionParam] = new HashSet[ActionParam]()

}
