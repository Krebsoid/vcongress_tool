package com.phanative.module.persistence.service.criteria

import org.codehaus.jackson.annotate.{JsonProperty, JsonIgnoreProperties}


@JsonIgnoreProperties(ignoreUnknown = true)
class GroupType {

  @JsonProperty
  var property: String = _

  @JsonProperty
  var direction: String = _

}