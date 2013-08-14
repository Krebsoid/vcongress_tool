package com.phanative.module.rest.provider.extjs.model

import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import javax.xml.bind.annotation.{XmlAccessorType, XmlElement, XmlAccessType, XmlRootElement}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ResponseData[E <: AnyRef] extends Response {

  locally {
    success = true
  }

  @XmlElement
  @JsonProperty
  var data: E = _

  override def toString: String = {
    new ToStringBuilder(this)
      .appendSuper(super.toString)
      .append("data", data)
      .toString
  }


}

