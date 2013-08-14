package com.phanative.module.persistence.service.criteria

import org.codehaus.jackson.annotate.{JsonProperty, JsonIgnoreProperties}


@JsonIgnoreProperties(ignoreUnknown = true)
class FilterType {

  @JsonProperty(value = "type")
  var dataType: String = _

  @JsonProperty
  var field: String = _

  @JsonProperty
  var value: Any = _

  @JsonProperty
  var comparison: String = _

}