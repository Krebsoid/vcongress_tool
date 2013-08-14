package com.phanative.resource.core.person.user

import address.AddressResource
import billaddress.BillAddressResource
import contact.ContactResource
import occupation.OccupationResource
import javax.ws.rs.core.MediaType
import com.phanative.module.rest.provider.extjs.model.ResponseData
import org.jboss.resteasy.annotations.Form
import javax.validation.Valid
import org.jboss.seam.rest.validation.ValidateRequest
import javax.ws.rs._
import javax.inject.Inject
import javax.enterprise.inject.Instance
import com.phanative.service.core.security.PersonRole
import com.phanative.service.core.GenderService
import com.phanative.module.persistence.service.repository.Repository
import com.phanative.module.security.service.repository.OneToCurrentIdentity
import com.phanative.model.core.person.{Gender, Person}
import javax.enterprise.context.ApplicationScoped
import welcome.PersonWelcomeType
import com.phanative.module.security.interceptor.{Recognized, Logging}

@PersonRole
@Path("person")
@ApplicationScoped
class PersonResource @Inject()(personService: OneToCurrentIdentity[Person],
                               subResourceInstance: Instance[PersonSubResource],
                               genderService: GenderService) {

  def this() = this(null, null, null)

  @Logging
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseData[PersonType] = {
    val person = personService.find()
    val personType = new PersonType
    personType.firstname = person.firstname
    personType.lastname = person.lastname
    if (person.gender != null)
      personType.gender = person.gender.name()
    personType.title = person.title

    val response = new ResponseData[PersonType]
    response.data = personType
    response.success = true
    response
  }

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Path("state")
  def state: ResponseData[PersonWelcomeType] = {
    val person = personService.find()
    val personType = new PersonWelcomeType
    personType.firstname = person.firstname
    personType.lastname = person.lastname

    val response = new ResponseData[PersonWelcomeType]
    response.data = personType
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @ValidateRequest
  def update(@Valid personType: PersonType): ResponseData[PersonType] = {
    val person = personService.find()
    person.firstname = personType.firstname
    person.lastname = personType.lastname
    if (personType.gender != "")
      person.gender = Gender.valueOf(personType.gender)
    person.title = personType.title
    personService.update(person)

    val response = new ResponseData[PersonType]
    response.data = personType
    response.success = true
    response
  }

  @Path("address")
  def address: AddressResource = {
    val person = personService.find()
    val addressResource = subResourceInstance.select(classOf[AddressResource]).get
    addressResource.address = person.address
    addressResource
  }

  @Path("billaddress")
  def billAddress: BillAddressResource = {
    val person = personService.find()
    val addressResource = subResourceInstance.select(classOf[BillAddressResource]).get
    addressResource.billAddress = person.billAddress
    addressResource
  }

  @Path("contact")
  def contact: ContactResource = {
    val person = personService.find()
    val contactResource = subResourceInstance.select(classOf[ContactResource]).get
    contactResource.contact = person.contact
    contactResource
  }

  @Path("occupation")
  def occupation: OccupationResource = {
    val person = personService.find()
    val occupationResource = subResourceInstance.select(classOf[OccupationResource]).get
    occupationResource.occupation = person.occupation
    occupationResource
  }

}