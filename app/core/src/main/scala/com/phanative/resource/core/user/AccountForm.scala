package com.phanative.resource.core.user

import javax.ws.rs.FormParam
import javax.validation.constraints.{NotNull, Size}
import org.hibernate.validator.constraints.Email
import org.apache.commons.lang.builder.ToStringBuilder

class AccountForm {

  @FormParam("username")
  @Email
  @NotNull
  var username: String = null

  @FormParam("password")
  @Size(min = 2, max = 32)
  @NotNull
  var password: String = null

  @FormParam("newPassword")
  @Size(min = 2, max = 32)
  @NotNull
  var newPassword: String = null

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }


}