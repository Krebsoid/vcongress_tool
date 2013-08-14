package com.phanative.resource.core.admin

import org.jboss.resteasy.annotations.Form
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.core.MediaType
import org.jboss.seam.rest.validation.ValidateRequest
import javax.ws.rs._
import com.phanative.service.core.security.AdministratorRole
import com.phanative.module.rest.provider.extjs.model.{ResponseData, ResponseObject}
import scala.collection.JavaConversions._
import javax.enterprise.context.ApplicationScoped
import org.jboss.seam.transaction.Transactional
import com.phanative.startup.configuration.Types
import org.picketlink.idm.api.IdentitySession
import com.phanative.module.security.interceptor.{Recognized, Logging}


@AdministratorRole
@ApplicationScoped
@Path("user")
class UserResource @Inject()(val identitySession: IdentitySession) {

  def this() = this(null)

  @Logging
  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read(@PathParam("id") userId: String): ResponseData[UserType] = {
    val user = identitySession.getPersistenceManager.findUser(userId)
    val usersGroup = identitySession.getPersistenceManager.findGroup(Types.UsersGroup, Types.GroupTypeGroup)

    val userType = new UserType
    userType.name = user.getKey
    val role = identitySession.getRoleManager.findRoleTypes(user, usersGroup)
    userType.roleName = role.head.getName

    val response = new ResponseData[UserType]
    response.data = userType
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Path("{userId}/rolechange")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_FORM_URLENCODED))
  @ValidateRequest
  @Transactional
  def updateRole(@PathParam("userId") userId: String, @Valid @Form roleForm: RoleForm): ResponseObject = {

    val usersGroup = identitySession.getPersistenceManager.findGroup(Types.UsersGroup, Types.GroupTypeGroup)
    val user = identitySession.getPersistenceManager.findUser(userId)
    val role = identitySession.getRoleManager.findRoleTypes(user, usersGroup)

    val newRoleType = identitySession.getRoleManager.getRoleType(roleForm.roleName)

    role.foreach(roleType => identitySession.getRoleManager.removeRole(roleType, user, usersGroup))
    identitySession.getRoleManager.createRole(newRoleType, user, usersGroup)

    val response = new ResponseObject
    response.success = true
    response
  }

}

