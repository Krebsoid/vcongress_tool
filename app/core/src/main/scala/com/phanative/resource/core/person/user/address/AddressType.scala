package com.phanative.resource.core.person.user.address

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class AddressType {
  @JsonProperty
  var street: String = null

  @JsonProperty
  var zipCode: String = null

  @JsonProperty
  var city: String = null

  @JsonProperty
  var country: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

