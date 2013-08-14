package com.phanative.resource.core.person.admin

import java.lang._
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class DetailedPersonType {
  @JsonProperty var id: Long = null
  @JsonProperty var email: String = null
  @JsonProperty var firstname: String = null
  @JsonProperty var lastname: String = null
  @JsonProperty var gender: String = null
  @JsonProperty var title: String = null
  @JsonProperty var position: String = null
  @JsonProperty var institute: String = null
  @JsonProperty var department: String = null
  @JsonProperty var phone: String = null
  @JsonProperty var fax: String = null
  @JsonProperty var street: String = null
  @JsonProperty var zipCode: String = null
  @JsonProperty var city: String = null
  @JsonProperty var country: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }
}

