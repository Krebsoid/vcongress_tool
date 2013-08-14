package com.phanative.resource.core.person.user

import java.lang._
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import org.hibernate.validator.constraints.NotEmpty
import com.phanative.module.core.validator.Gender

class PersonType {

  @JsonProperty
  var id: Long = null

  @JsonProperty
  @NotEmpty
  var firstname: String = null

  @JsonProperty
  @NotEmpty
  var lastname: String = null

  @JsonProperty
  @Gender
  var gender: String = null

  @JsonProperty
  var title: String = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }
}

