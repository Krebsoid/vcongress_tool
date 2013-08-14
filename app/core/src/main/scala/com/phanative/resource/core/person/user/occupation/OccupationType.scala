package com.phanative.resource.core.person.user.occupation

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import org.hibernate.validator.constraints.NotEmpty

class OccupationType {

  @JsonProperty
  var position: String = null

  @JsonProperty
  @NotEmpty
  var institute: String = null

  @JsonProperty
  var department: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

