package com.phanative.startup.scenario

import com.phanative.module.security.model.EnabledAttribute
import org.picketlink.idm.api._
import javax.inject.Inject
import java.lang._
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped
import com.phanative.startup.data.Data001SeamSecurity
import javax.persistence.EntityManager

@ApplicationScoped
class Scenario000User @Inject()(identitySession: IdentitySession,
                                entityManager: EntityManager,
                                seamSecurity: Data001SeamSecurity) extends Scenario {

  def this() = this(null, null, null)

  var erna: User = _
  var user: User = _
  var suborganiser: User = _
  var admin: User = _
  var organiser: User = _
  var reviewer: User = _

  @Transactional
  def initialize() {
    val persistenceManager: PersistenceManager = identitySession.getPersistenceManager
    val roleManager: RoleManager = identitySession.getRoleManager
    val attributesManager: AttributesManager = identitySession.getAttributesManager
    val enabled: Array[Attribute] = Array(new EnabledAttribute(String.valueOf(true)).asInstanceOf[Attribute])
    val disabled: Array[Attribute] = Array(new EnabledAttribute(String.valueOf(false)).asInstanceOf[Attribute])

    erna = persistenceManager.createUser("erna@erna.de")
    attributesManager.updatePassword(erna, "Erna")
    attributesManager.addAttributes(erna, enabled)
    roleManager.createRole(seamSecurity.personRoleType, erna, seamSecurity.userGroup)

    user = persistenceManager.createUser("user@user.de")
    attributesManager.updatePassword(user, "user")
    attributesManager.addAttributes(user, enabled)
    roleManager.createRole(seamSecurity.personRoleType, user, seamSecurity.userGroup)

    admin = persistenceManager.createUser("admin@admin.de")
    attributesManager.updatePassword(admin, "admin")
    attributesManager.addAttributes(admin, enabled)
    roleManager.createRole(seamSecurity.adminRoleType, admin, seamSecurity.userGroup)

    organiser = persistenceManager.createUser("organiser@organiser.de")
    attributesManager.updatePassword(organiser, "organiser")
    attributesManager.addAttributes(organiser, enabled)
    roleManager.createRole(seamSecurity.organiserRoleType, organiser, seamSecurity.userGroup)

    suborganiser = persistenceManager.createUser("suborganiser@suborganiser.de")
    attributesManager.updatePassword(suborganiser, "suborganiser")
    attributesManager.addAttributes(suborganiser, enabled)
    roleManager.createRole(seamSecurity.subOrganiserRoleType, suborganiser, seamSecurity.userGroup)

    reviewer = persistenceManager.createUser("reviewer@reviewer.de")
    attributesManager.updatePassword(reviewer, "reviewer")
    attributesManager.addAttributes(reviewer, enabled)
    roleManager.createRole(seamSecurity.reviewerRoleType, reviewer, seamSecurity.userGroup)


  }

  def index() = 0

  def name() = "UserScenario"
}