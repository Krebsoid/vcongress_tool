package com.phanative.resource.core.person.user.billaddress

import com.phanative.model.core.person.{CountryQuery, Country, BillAddress, Address}
import com.phanative.module.rest.provider.extjs.model.ResponseData
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
class BillAddressResource @Inject()(entityManager: EntityManager,
                                    countryRepository: Repository[Country])
  extends PersonSubResource {

  def this() = this(null, null)

  var billAddress: BillAddress = null

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseData[BillAddressType] = {
    val addressType = new BillAddressType
    addressType.fullName = billAddress.fullName
    addressType.institute = billAddress.institute
    addressType.street = billAddress.street
    addressType.zipCode = billAddress.zipCode
    addressType.city = billAddress.city
    if(billAddress.country != null) {
      addressType.country = billAddress.country.isoCode
    }

    val response = new ResponseData[BillAddressType]
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
  def update(@Valid billAddressType: BillAddressType): ResponseData[BillAddressType] = {
    billAddress.fullName = billAddressType.fullName
    billAddress.institute = billAddressType.institute
    billAddress.city = billAddressType.city
    billAddress.country = countryRepository.find(CountryQuery.ByIsoCode(billAddressType.country))
    billAddress.zipCode = billAddressType.zipCode
    billAddress.street = billAddressType.street
    entityManager.merge(billAddress)

    val response = new ResponseData[BillAddressType]
    response.data = billAddressType
    response.success = true
    response
  }

}

