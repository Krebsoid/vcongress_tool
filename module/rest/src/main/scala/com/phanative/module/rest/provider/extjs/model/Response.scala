package com.phanative.module.rest.provider.extjs.model

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import javax.xml.bind.annotation.{XmlAccessorType, XmlElement, XmlAccessType, XmlRootElement}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Response {

  @XmlElement
  @JsonProperty
  var message: String = _

  @XmlElement
  @JsonProperty
  var success: Boolean = _

  override def toString: String = {
    new ToStringBuilder(this)
      .append("message", message)
      .append("success?", success)
      .toString
  }

}