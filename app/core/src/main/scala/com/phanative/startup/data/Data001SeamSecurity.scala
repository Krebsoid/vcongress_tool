package com.phanative.startup.data

import javax.inject._
import org.picketlink.idm.api._
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped
import com.phanative.startup.configuration.Types._

@ApplicationScoped
class Data001SeamSecurity @Inject()(identitySession: IdentitySession) extends Data {

  def this() = this(null)

  var userGroup: Group = _
  var personRoleType: RoleType = _
  var reviewerRoleType: RoleType = _
  var organiserRoleType: RoleType = _
  var subOrganiserRoleType: RoleType = _
  var adminRoleType: RoleType = _

  @Transactional
  def initialize() {
    userGroup = identitySession.getPersistenceManager.createGroup(UsersGroup, GroupTypeGroup)
    adminRoleType = identitySession.getRoleManager.createRoleType(adminRole)
    personRoleType = identitySession.getRoleManager.createRoleType(personRole)
    organiserRoleType = identitySession.getRoleManager.createRoleType(organiserRole)
    subOrganiserRoleType = identitySession.getRoleManager.createRoleType(subOrganiserRole)
    reviewerRoleType = identitySession.getRoleManager.createRoleType(reviewerRole)
  }

  def index() = 1

  def name() = "SeamSecurity"
}
