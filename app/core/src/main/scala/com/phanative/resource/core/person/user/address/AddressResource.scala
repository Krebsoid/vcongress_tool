package com.phanative.resource.core.person.user.address

import com.phanative.model.core.person.{CountryQuery, Country, Address}
import com.phanative.module.rest.provider.extjs.model.ResponseData
import org.jboss.resteasy.annotations.Form
import org.jboss.seam.rest.validation.ValidateRequest
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.Dependent
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.validation.Valid
import javax.ws.rs._
import javax.ws.rs.core.MediaType
import com.phanative.service.core.security.PersonRole
import com.phanative.resource.core.person.user.PersonSubResource
import com.phanative.module.security.interceptor.{Recognized, Logging}
import com.phanative.module.persistence.service.repository.Repository

@PersonRole
@Dependent
class AddressResource @Inject()(entityManager: EntityManager,
                                countryRepository: Repository[Country])
  extends PersonSubResource {

  def this() = this(null, null)

  var address: Address = null

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseData[AddressType] = {
    val addressType = new AddressType
    addressType.street = address.street
    addressType.zipCode = address.zipCode
    addressType.city = address.city
    if(address.country != null) {
      addressType.country = address.country.isoCode
    }

    val response = new ResponseData[AddressType]
    response.data = addressType
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @ValidateRequest
  @Transactional
  def update(@Valid addressType: AddressType): ResponseData[AddressType] = {
    address.city = addressType.city
    address.country = countryRepository.find(CountryQuery.ByIsoCode(addressType.country))
    address.zipCode = addressType.zipCode
    address.street = addressType.street
    entityManager.merge(address)

    val response = new ResponseData[AddressType]
    response.data = addressType
    response.success = true
    response
  }

}

