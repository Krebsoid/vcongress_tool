package com.phanative.resource.core.person.admin

import java.lang._
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class ErrorType {

  @JsonProperty var msg: String = null
  @JsonProperty var field: String = null
  @JsonProperty var value: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

