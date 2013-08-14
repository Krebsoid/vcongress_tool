package com.phanative.resource.core.admin

import javax.ws.rs.FormParam
import org.apache.commons.lang.builder.ToStringBuilder

class RoleForm {

  @FormParam("roleName")
  var roleName: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }


}

