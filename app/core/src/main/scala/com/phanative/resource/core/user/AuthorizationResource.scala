package com.phanative.resource.core.user

import com.phanative.module.persistence.service.collection.PagedHashSet
import com.phanative.module.persistence.service.collection.PagedCollection
import org.picketlink.idm.api.Role
import javax.inject.Inject
import javax.ws.rs._
import core.{Response, MediaType}
import scala.collection.JavaConversions._
import org.jboss.seam.security.annotations.LoggedIn
import org.apache.commons.lang.StringUtils
import org.jboss.seam.rest.validation.ValidateRequest
import javax.validation.Valid
import org.jboss.resteasy.annotations.Form
import com.phanative.module.rest.provider.extjs.model.{ResponseCollection, ResponseObject}
import com.phanative.module.security.service.ActiveIdentity
import javax.enterprise.context.ApplicationScoped
import com.phanative.service.core.security.{PersonRole, LoggedOut}
import com.phanative.service.core.RecoveryService
import org.jboss.solder.logging.Logger
import org.jboss.seam.security.Identity
import org.jboss.seam.transaction.Transactional
import org.jboss.solder.core.Client
import org.jboss.seam.international.Alter
import javax.enterprise.event.Event
import java.util.{Locale, Set}
import com.phanative.module.security.interceptor.{Logging, Param, Recognized}
import com.phanative.service.core.mail.PasswordRecoveryMailService

@Path("account")
@ApplicationScoped
class AuthorizationResource @Inject()(activeIdentity: ActiveIdentity,
                                      identity: Identity,
                                      recoveryService: RecoveryService,
                                      passwordRecoveryMailService: PasswordRecoveryMailService,
                                      logger: Logger) {

  def this() = this(null, null, null, null, null)

  @Inject
  @Client
  @Alter
  var localeEvent: Event[Locale] = null

  @LoggedOut
  @Recognized(params = Array(
    new Param(name = "username",paramIndex = 0)
  ))
  @POST
  @Path("authenticate")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def authenticate(@FormParam("username") username: String,
                   @FormParam("password") password: String): ResponseCollection[RoleType] = {
    logger.info("User(" + username + ") tries to log in")
    val roles = activeIdentity.login(StringUtils.lowerCase(username.trim), password.trim)

    val response = new ResponseCollection[RoleType]
    response.data = rolesToRoleTypes(roles)
    response.total = roles.size()
    response
  }

  @Logging
  @Recognized
  @PersonRole
  @POST
  @ValidateRequest
  @Transactional
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_FORM_URLENCODED))
  def update(@Valid @Form accountForm: AccountForm): ResponseObject = {

    activeIdentity.update(StringUtils.lowerCase(accountForm.username),
      accountForm.password,
      accountForm.newPassword)

    new ResponseObject {
      success = true
    }
  }

  @Logging
  @Recognized
  @LoggedIn
  @GET
  @Path("logout")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def logout: ResponseObject = {
    identity.logout()
    new ResponseObject
  }

  @Logging
  @POST
  @Path("recover")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_FORM_URLENCODED))
  @ValidateRequest
  def recoverPassword(@Valid @Form passwordRecoveryForm: PasswordRecoveryForm): ResponseObject = {
    recoveryService.recoverPassword(StringUtils.lowerCase(passwordRecoveryForm.email.trim))

    val response = new ResponseObject
    response.success = true
    response
  }

  @Path("recover/test")
  @GET
  def registerTest: Response = {
    val responseBuilder: Response.ResponseBuilder = Response.ok(passwordRecoveryMailService.testHTML())
    responseBuilder.header("Content-Type", "text/html")
    responseBuilder.build
  }


  @GET
  @Path("state")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def state: StateResponse = {
    val roles = identity.getRoles
    val response = new StateResponse
    response.roles = rolesToRoleTypes(roles)
    response
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

