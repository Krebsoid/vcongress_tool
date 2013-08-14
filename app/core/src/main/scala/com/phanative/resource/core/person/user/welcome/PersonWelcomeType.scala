package com.phanative.resource.core.person.user.welcome

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class PersonWelcomeType {
  @JsonProperty
  var firstname: String = null

  @JsonProperty
  var lastname: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

