package com.phanative.model.congress

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence._

@Entity
class AdditionalParticipation extends AbstractEntity {

  @OneToOne(optional = false)
  var participation: Participation = _

  @ManyToOne(cascade = Array(CascadeType.ALL))
  var status: ParticipantStatus = _
  var statusFixed: Boolean = false

  var workshop1: Boolean = _
  var workshop1Fixed: Boolean = _

  var workshop2: Boolean = _
  var workshop2Fixed: Boolean = _

  var workshop3: Boolean = _
  var workshop3Fixed: Boolean = _

  var eveningEventTickets: Int = _
  var eveningEventTicketsFixed: Int = _
  var eveningEventTicketsMax: Int = 5

  var exhibitor: Boolean = _
  var speaker: Boolean = _
  var present: Boolean = _

  var participationFixed: Boolean = _

}
