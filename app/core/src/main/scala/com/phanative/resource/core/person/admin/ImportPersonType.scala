package com.phanative.resource.core.person.admin

import java.lang._
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import com.phanative.module.security.validation.constraints.UniqueEmail
import java.util.ArrayList
import org.hibernate.validator.constraints.{Email, NotEmpty}
import com.phanative.module.core.validator.Gender
import javax.validation.constraints.AssertFalse

class ImportPersonType {
  @JsonProperty var id: Long = null
  @JsonProperty var row: Int = _
  @JsonProperty @Email @NotEmpty @UniqueEmail(message = "{com.phanative.seam.validation.constraints.UniqueEmail.shortMessage}")
  var email: String = null
  @JsonProperty var password: String = null
  @JsonProperty var firstname: String = null
  @JsonProperty @NotEmpty var lastname: String = null
  @JsonProperty @Gender var gender: String = null
  @JsonProperty var title: String = null
  @JsonProperty var position: String = null
  @JsonProperty var institute: String = null
  @JsonProperty var department: String = null
  @JsonProperty var phone: String = null
  @JsonProperty var fax: String = null
  @JsonProperty var street: String = null
  @JsonProperty var zipCode: String = null
  @JsonProperty var city: String = null
  @JsonProperty var countryCode: String = null
  @JsonProperty var country: String = null

  @JsonProperty var erroneous: Boolean = false
  @JsonProperty @AssertFalse(message = "{com.phanative.seam.validation.constraints.UniqueEmail.collection}")
  var duplicate: Boolean = false

  @JsonProperty
  var errors: ArrayList[ErrorType] = new ArrayList[ErrorType]()

  override def toString: String = {
    ToStringBuilder.reflectionToString(this)
  }

}

