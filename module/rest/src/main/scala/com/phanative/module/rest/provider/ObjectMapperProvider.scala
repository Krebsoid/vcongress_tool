package com.phanative.module.rest.provider

import javax.ws.rs.ext.{Provider, ContextResolver}
import javax.ws.rs.core.MediaType
import java.lang.Class
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.codehaus.jackson.map.annotate.JsonSerialize
import javax.ws.rs.Produces
import org.codehaus.jackson.map.{SerializationConfig, DeserializationConfig, ObjectMapper}

@Provider
@Produces(Array(MediaType.APPLICATION_JSON))
class ObjectMapperProvider extends ContextResolver[ObjectMapper] {

  val objectMapper = new ObjectMapper()

  locally {
    objectMapper
      .registerModule(DefaultScalaModule)

    objectMapper
      .configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false)

    objectMapper
      .getSerializationConfig
      .withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL)
  }

  def getContext(aClass: Class[_]): ObjectMapper = objectMapper
}