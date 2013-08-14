package com.phanative.model.congress

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence._
import com.phanative.model.core.person.OneToPerson
import org.joda.time.LocalDate

@Entity
class Participation extends AbstractEntity with OneToPerson {

  var vipStatus: Boolean = _

  var notice: String = _

  var regDate: LocalDate = _

  var participating: Boolean = true

}