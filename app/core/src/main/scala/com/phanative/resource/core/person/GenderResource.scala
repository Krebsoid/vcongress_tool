package com.phanative.resource.core.person

import scala.Array._
import javax.ws.rs.core.MediaType
import com.phanative.module.rest.provider.extjs.model.ResponseCollection
import collection.JavaConversions._
import com.phanative.model.core.person.Gender
import javax.inject.Inject
import com.phanative.service.core.GenderService
import javax.ws.rs.{Path, Produces, GET}
import javax.enterprise.context.ApplicationScoped

@Path("person/genders")
@ApplicationScoped
class GenderResource @Inject()(val genderService: GenderService) {

  def this() = this (null)

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseCollection[GenderType] = {

    val genderTypes = Gender.values().map(gender => {
      val genderType = new GenderType
      genderType.name = gender.name().toLowerCase
      genderType.id = genderService.id(gender)
      genderType
    }).filter(gender => gender.name != Gender.NO_GENDER.name().toLowerCase)

    val response = new ResponseCollection[GenderType]
    response.data = genderTypes.toList
    response.success = true

    response
  }


}