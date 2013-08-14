package com.phanative.resource.core.person.user.billaddress

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class BillAddressType {
  @JsonProperty
  var fullName: String = null

  @JsonProperty
  var institute: String = null

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

