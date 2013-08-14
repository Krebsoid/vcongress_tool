package com.phanative.resource.core.admin

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class UserRoleType {
  @JsonProperty var roleName: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

