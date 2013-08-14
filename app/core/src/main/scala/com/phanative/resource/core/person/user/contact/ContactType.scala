package com.phanative.resource.core.person.user.contact

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import org.hibernate.validator.constraints.{NotEmpty, Email}

class ContactType {
  @JsonProperty
  var phone: String = null

  @JsonProperty
  var fax: String = null

  @JsonProperty
  @NotEmpty
  @Email
  var email: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

