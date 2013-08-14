package com.phanative.resource.core.admin

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import scala.collection.JavaConversions._
import javax.ws.rs._
import com.phanative.module.rest.provider.extjs.model.ResponseCollection
import com.phanative.service.core.security.AdministratorRole
import org.picketlink.idm.api.IdentitySession


@AdministratorRole
@Path("role")
class RoleResource @Inject()(identitySession: IdentitySession) {

  def this() = this(null)

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readAll: ResponseCollection[UserRoleType] = {
    val roles = identitySession.getRoleManager.findRoleTypes()


    val userRoleTypes = roles.map(roleType => {
      val userRoleType = new UserRoleType
      userRoleType.roleName = roleType.getName
      userRoleType
    })

    val response = new ResponseCollection[UserRoleType]
    response.data = userRoleTypes
    response.total = roles.size()
    response.success = true
    response
  }

}

