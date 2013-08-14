package com.phanative.resource.core.user

import javax.ws.rs.FormParam
import org.hibernate.validator.constraints.Email
import com.phanative.module.security.validation.constraints.UniqueEmail
import javax.validation.constraints._
import org.apache.commons.lang.builder.ToStringBuilder
import com.phanative.module.core.validator.Gender

class RegistrationForm {

  @FormParam("email")
  @Email
  @UniqueEmail
  @NotNull
  var email: String = null

  @FormParam("contactEmail")
  @Email
  var contactEmail: String = null

  @FormParam("password")
  @NotNull
  @Size(min = 3, max = 32)
  var password: String = null

  @FormParam("gender")
  @Gender
  var gender: String = null

  @FormParam("title")
  @Size(max = 32)
  var title: String = null

  @FormParam("firstname")
  @Size(min = 2, max = 64)
  @NotNull
  var firstname: String = null

  @FormParam("lastname")
  @Size(min = 2, max = 64)
  @NotNull
  var lastname: String = null

  @FormParam("position")
  @Size(max = 128)
  var position: String = null

  @FormParam("department")
  @Size(max = 128)
  var department: String = null

  @FormParam("institute")
  @Size(min = 2, max = 128)
  @NotNull
  var institute: String = null

  @FormParam("phone")
  @Size(min = 2, max = 128)
  @NotNull
  var phone: String = null

  @FormParam("fax")
  @Size(max = 128)
  var fax: String = null

  @FormParam("street")
  @NotNull
  @Size(min = 3, max = 128)
  var street: String = null

  @FormParam("zipCode")
  @Size(min = 2, max = 64)
  @NotNull
  var zipCode: String = null

  @FormParam("city")
  @Size(min = 2, max = 128)
  @NotNull
  var city: String = null

  @FormParam("country")
  @Size(min = 2, max = 128)
  @NotNull
  var country: String = null

  @FormParam("notification")
  var notification: Boolean = _

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }


}
