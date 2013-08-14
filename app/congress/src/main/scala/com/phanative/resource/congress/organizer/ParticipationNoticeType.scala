package com.phanative.resource.congress.organizer

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class ParticipationNoticeType {

  @JsonProperty
  var id: Long = _

  @JsonProperty
  var notice: String = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }
}
