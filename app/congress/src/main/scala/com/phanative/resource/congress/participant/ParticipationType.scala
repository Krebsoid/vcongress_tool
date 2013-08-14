package com.phanative.resource.congress.participant

import org.codehaus.jackson.annotate.JsonProperty
import java.lang.Long
import org.apache.commons.lang.builder.ToStringBuilder

class ParticipationType {

  @JsonProperty
  var id: Long = _

  @JsonProperty
  var participationStatusId: Long = _

  @JsonProperty
  var participationStatusIdFixed: Boolean = _

  @JsonProperty
  var workshop1: Boolean = _

  @JsonProperty
  var workshop1Fixed: Boolean = _

  @JsonProperty
  var workshop2: Boolean = _

  @JsonProperty
  var workshop2Fixed: Boolean = _

  @JsonProperty
  var workshop3: Boolean = _

  @JsonProperty
  var workshop3Fixed: Boolean = _

  @JsonProperty
  var eveningEventTickets: Int = _
  @JsonProperty
  var eveningEventTicketsFixed: Int = _
  @JsonProperty
  var eveningEventTicketsMax: Int = _

  @JsonProperty
  var dirty : Boolean = false

  @JsonProperty
  var vipStatus : Boolean = false

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

