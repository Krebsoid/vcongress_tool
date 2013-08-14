package com.phanative.resource.core.person

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class GenderType {

  @JsonProperty var id: Long = _
  @JsonProperty var name: String = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }


}