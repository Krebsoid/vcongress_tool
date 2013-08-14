package com.phanative.model.congress

import org.joda.time.LocalDate
import com.phanative.module.persistence.model.{AbstractEntity, LocaleString}
import javax.persistence._

@Entity
class ParticipantStatus extends AbstractEntity {

  @OneToOne(cascade = Array(CascadeType.ALL))
  var name: LocaleString = new LocaleString

  @Column(name = "beginDate")
  var begin: LocalDate = _

  @Column(name = "endDate")
  var end: LocalDate = _

  var noParticipation: Boolean = false
  var vip: Boolean = false
  var choosable: Boolean = true


}