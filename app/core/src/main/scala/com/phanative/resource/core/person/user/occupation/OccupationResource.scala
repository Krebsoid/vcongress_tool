package com.phanative.resource.core.person.user.occupation

import com.phanative.model.core.person.Occupation
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

@PersonRole
@Dependent
class OccupationResource @Inject()(entityManager: EntityManager)
  extends PersonSubResource {

  def this() = this(null)

  var occupation: Occupation = null

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseData[OccupationType] = {
    val occupationType = new OccupationType
    occupationType.department = occupation.department
    occupationType.institute = occupation.institute
    occupationType.position = occupation.position

    val response = new ResponseData[OccupationType]
    response.data = occupationType
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
  def update(@Valid occupationType: OccupationType): ResponseData[OccupationType] = {
    occupation.department = occupationType.department
    occupation.institute = occupationType.institute
    occupation.position = occupationType.position
    entityManager.merge(occupation)

    val response = new ResponseData[OccupationType]
    response.data = occupationType
    response.success = true
    response

  }
}

