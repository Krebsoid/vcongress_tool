package com.phanative.module.rest.provider.extjs.model

import java.util.List
import org.codehaus.jackson.annotate.JsonProperty
import org.apache.commons.lang.builder.ToStringBuilder
import javax.xml.bind.annotation._

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ResponseValidationException extends ResponseException {

  locally {
    message = "Validation Exception"
  }

  @XmlElementWrapper
  @XmlElementRef
  @JsonProperty
  var errors: List[ResponseValidationException.Field] = _

  override def toString: String = {
    new ToStringBuilder(this)
      .appendSuper(super.toString)
      .append("error", errors)
      .toString
  }


}


object ResponseValidationException {

  @XmlRootElement(name = "error")
  @JsonProperty
  class Field {

    @XmlElement
    @JsonProperty
    var id: String = _

    @XmlElement
    @JsonProperty
    var msg: String = _

    override def toString: String = {
      new ToStringBuilder(this)
        .append("field id", id)
        .append("msg", msg)
        .toString
    }

  }

}


