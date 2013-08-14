package com.phanative.module.rest.provider.extjs.model

import java.util.Collection
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class ResponseCollection[E] extends Response {

  locally {
    success = true
  }

  @JsonProperty
  var total: Int = _

  @JsonProperty
  var data: Collection[E] = null

  override def toString: String = {
    new ToStringBuilder(this)
      .appendSuper(super.toString)
      .append("total", total)
      .append("data", data)
      .toString
  }
}

