package com.phanative.resource.congress

import org.codehaus.jackson.annotate.JsonProperty
import java.lang.Long
import org.apache.commons.lang.builder.ToStringBuilder

class EventTicketCountType {

  @JsonProperty
  var id: Long = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}