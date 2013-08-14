package com.phanative.resource.core.user

import org.hibernate.validator.constraints.Email
import javax.ws.rs.FormParam
import javax.validation.constraints._
import org.apache.commons.lang.builder.ToStringBuilder


class PasswordRecoveryForm {
  @NotNull
  @Email
  @FormParam("email")
  var email: String = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}
