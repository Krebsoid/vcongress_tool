package com.phanative.module.persistence.service.criteria

import org.codehaus.jackson.annotate.{JsonProperty, JsonIgnoreProperties}


@JsonIgnoreProperties(ignoreUnknown = true)
class SortType {

  @JsonProperty
  var property: String = _

  @JsonProperty
  var direction: String = _

}