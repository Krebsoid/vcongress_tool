package com.phanative.resource.core.user

import com.phanative.module.rest.provider.extjs.model.Response
import java.net.URI
import com.phanative.module.rest.RestUtils._
import java.util.Collection
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder

class StateResponse extends Response {
  locally {
    success = true
  }

  @JsonProperty var roles: Collection[RoleType] = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }
}
