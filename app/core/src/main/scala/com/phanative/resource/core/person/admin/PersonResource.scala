package com.phanative.resource.core.person.admin

import javax.ws.rs.core.MediaType
import javax.validation.Valid
import org.jboss.seam.rest.validation.ValidateRequest
import javax.ws.rs._
import javax.inject.Inject
import com.phanative.module.rest.provider.extjs.model.ResponseData
import java.lang.Long
import com.phanative.module.persistence.service.repository.Repository
import javax.enterprise.context.ApplicationScoped
import com.phanative.module.security.interceptor.{Recognized, Logging}
import com.phanative.model.core.person.{Gender, Person}
import com.phanative.service.core.security.OrganizerRole
import com.phanative.resource.core.person.user.address.AddressResource
import com.phanative.resource.core.person.user.contact.ContactResource
import com.phanative.resource.core.person.user.occupation.OccupationResource
import javax.enterprise.inject.Instance
import com.phanative.resource.core.person.user.{PersonType, PersonSubResource}
import com.phanative.service.core.GenderService
import com.phanative.resource.core.person.user.billaddress.BillAddressResource

@OrganizerRole
@Path("persons")
@ApplicationScoped
class PersonResource @Inject()(val personService: Repository[Person],
                               subResourceInstance: Instance[PersonSubResource],
                               genderService: GenderService) {

  def this() = this(null, null, null)

  @Logging
  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readByOrganizer(@PathParam("id") personId: Long): ResponseData[PersonType] = {
    val person = personService.findById(personId)
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

  @Logging
  @GET
  @Path("detailed/{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readDetailed(@PathParam("id") personId: Long): ResponseData[DetailedPersonType] = {
    val person = personService.findById(personId)

    val personType = new DetailedPersonType
    personType.id = person.id
    personType.firstname = person.firstname
    personType.lastname = person.lastname
    if(person.gender != null)
      personType.gender = person.gender.name()
    personType.title = person.title
    personType.street = person.address.street
    personType.city = person.address.city
    personType.zipCode = person.address.zipCode
    if(person.address.country != null) {
      personType.country = person.address.country.name.get()
    }
    else {
      personType.country = ""
    }
    personType.institute = person.occupation.institute
    personType.department = person.occupation.department
    personType.position = person.occupation.position
    personType.phone = person.contact.phone
    personType.fax = person.contact.fax
    personType.email = person.contact.email

    val response = new ResponseData[DetailedPersonType]
    response.data = personType
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @ValidateRequest
  def updateByOrganizer(@PathParam("id") personId: Long, @Valid personType: PersonType): ResponseData[PersonType] = {
    val person = personService.findById(personId)
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

  @Path("{id}/address")
  def address(@PathParam("id") personId: Long): AddressResource = {
    val person = personService.findById(personId)
    val addressResource = subResourceInstance.select(classOf[AddressResource]).get
    addressResource.address = person.address
    addressResource
  }

  @Path("{id}/billaddress")
  def billaddress(@PathParam("id") personId: Long): BillAddressResource = {
    val person = personService.findById(personId)
    val billAddressResource = subResourceInstance.select(classOf[BillAddressResource]).get
    billAddressResource.billAddress = person.billAddress
    billAddressResource
  }

  @Path("{id}/contact")
  def contact(@PathParam("id") personId: Long): ContactResource = {
    val person = personService.findById(personId)
    val contactResource = subResourceInstance.select(classOf[ContactResource]).get
    contactResource.contact = person.contact
    contactResource
  }

  @Path("{id}/occupation")
  def occupation(@PathParam("id") personId: Long): OccupationResource = {
    val person = personService.findById(personId)
    val occupationResource = subResourceInstance.select(classOf[OccupationResource]).get
    occupationResource.occupation = person.occupation
    occupationResource
  }

}