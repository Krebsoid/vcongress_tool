package com.phanative.resource.core.user

import org.jboss.resteasy.annotations.Form
import org.jboss.seam.rest.validation.ValidateRequest
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs._
import com.phanative.module.rest.provider.extjs.model.ResponseObject
import com.phanative.module.persistence.service.collection.{PagedHashSet, PagedCollection}
import collection.JavaConversions._
import core.{MediaType, Response}
import java.util.Set
import com.phanative.module.security.service.ActiveIdentity
import org.apache.commons.lang.StringUtils
import com.phanative.module.security.service.repository.OneToCurrentIdentity
import org.picketlink.idm.api.Role
import javax.enterprise.context.ApplicationScoped
import com.phanative.service.core.security.LoggedOut
import com.phanative.service.core.{GenderService, RegisterService}
import com.phanative.module.security.interceptor.{Recognized, Logging}
import com.phanative.model.core.person.{CountryQuery, Country, Gender, Person}
import com.phanative.module.persistence.service.repository.Repository
import com.phanative.service.core.mail.RegistrationMailService

@Path("register")
@ApplicationScoped
class RegistrationResource @Inject()(activeIdentity: ActiveIdentity,
                                     registerService: RegisterService,
                                     currentPerson: OneToCurrentIdentity[Person],
                                     countryRepository: Repository[Country],
                                     registrationMailService: RegistrationMailService,
                                     genderService: GenderService) extends Serializable {

  def this() = this(null, null, null, null, null, null)


  @Logging("registered successfully")
  @Recognized
  @LoggedOut
  @POST
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_FORM_URLENCODED))
  @ValidateRequest
  def register(@Valid @Form form: RegistrationForm): ResponseObject = {
    val email = StringUtils.lowerCase(form.email)
    val user = registerService.register(email, form.password)
    activeIdentity.login(email, form.password)

    val person = new Person
    person.title = form.title
    person.gender = Gender.valueOf(form.gender)
    person.firstname = form.firstname
    person.lastname = form.lastname
    person.occupation.position = form.position
    person.occupation.institute = form.institute
    person.occupation.department = form.department
    person.contact.email = if (StringUtils.isNotEmpty(form.contactEmail)) form.contactEmail else form.email
    person.contact.phone = form.phone
    person.contact.fax = form.fax
    person.address.street = form.street
    person.address.city = form.city
    person.address.zipCode = form.zipCode
    person.address.country = countryRepository.find(CountryQuery.ByIsoCode(form.country))

    val title: String = if(form.title != null) (form.title + " ") else ""
    val fullName: String = title + form.firstname + " " + form.lastname
    person.billAddress.fullName = fullName
    person.billAddress.institute = form.institute
    person.billAddress.street = form.street
    person.billAddress.city = form.city
    person.billAddress.zipCode = form.zipCode
    person.billAddress.country = countryRepository.find(CountryQuery.ByIsoCode(form.country))
    person.notificationOptions.commonNewsletter = form.notification

    currentPerson.save(person)
    registerService.sendRegistrationEmail(user, person)

    new ResponseObject
  }

  @Path("test")
  @GET
  def registerTest: Response = {
    val responseBuilder: Response.ResponseBuilder = Response.ok(registrationMailService.testHTML())
    responseBuilder.header("Content-Type", "text/html")
    responseBuilder.build
  }

  protected def rolesToRoleTypes(roles: Set[Role]): PagedCollection[RoleType] = {
    val pagedHashSet = new PagedHashSet[RoleType]

    val roleTypes = roles.map(role => {
      val roleType = new RoleType
      roleType.group = role.getGroup.getName
      roleType.groupType = role.getGroup.getGroupType
      roleType.userId = role.getUser.getId
      roleType.roleType = role.getRoleType.getName
      roleType
    })

    pagedHashSet.total = roles.size()
    pagedHashSet.addAll(roleTypes)
    pagedHashSet
  }


}
