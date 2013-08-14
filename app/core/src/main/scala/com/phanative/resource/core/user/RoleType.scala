package com.phanative.resource.core.user

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class RoleType {
  @JsonProperty var group: String = _
  @JsonProperty var groupType: String = _
  @JsonProperty var roleType: String = _
  @JsonProperty var userId: String = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }
}
