package com.phanative.resource.core.person

import javax.ws.rs.core.MediaType
import com.phanative.module.rest.provider.extjs.model.ResponseCollection
import collection.JavaConversions._
import com.phanative.model.core.person.{Country, Gender}
import javax.inject.Inject
import javax.ws.rs.{Path, Produces, GET}
import javax.enterprise.context.ApplicationScoped
import com.phanative.module.persistence.service.repository.Repository

@Path("person/countries")
@ApplicationScoped
class CountryResource @Inject()(val countryRepository: Repository[Country]) {

  def this() = this (null)

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseCollection[CountryType] = {

    val genderTypes = countryRepository.findAll().map(country => {
      val countryType = new CountryType
      countryType.name = country.name.get()
      countryType.id = country.isoCode
      countryType
    })

    val response = new ResponseCollection[CountryType]
    response.data = genderTypes.toList.sortBy(country => country.name)
    response.success = true

    response
  }


}