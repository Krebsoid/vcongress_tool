package com.phanative.resource.core.person.user.contact

import com.phanative.model.core.person.Contact
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
import org.apache.commons.lang.StringUtils
import com.phanative.service.core.security.PersonRole
import com.phanative.resource.core.person.user.PersonSubResource
import com.phanative.module.security.interceptor.{Recognized, Logging}

@PersonRole
@Dependent
class ContactResource @Inject()(entitymanager: EntityManager)
  extends PersonSubResource {

  def this() = this(null)

  var contact: Contact = null

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseData[ContactType] = {
    val contactType = new ContactType
    contactType.phone = contact.phone
    contactType.fax = contact.fax
    contactType.email = contact.email

    val response = new ResponseData[ContactType]
    response.data = contactType
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @ValidateRequest
  @Transactional def update(@Valid contactType: ContactType): ResponseData[ContactType] = {
    contact.fax = contactType.fax
    contact.phone = contactType.phone
    contact.email = StringUtils.lowerCase(contactType.email)
    entitymanager.merge(contact)

    val response = new ResponseData[ContactType]
    response.data = contactType
    response.success = true
    response
  }

}

