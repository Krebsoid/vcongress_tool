package com.phanative.startup.data

import com.phanative.module.security.model.EnabledAttribute
import org.picketlink.idm.api._
import javax.inject.Inject
import java.lang._
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped
import javax.persistence.EntityManager

@ApplicationScoped
class Data002Admin @Inject()(identitySession: IdentitySession,
                             seamSecurity: Data001SeamSecurity,
                             entityManager : EntityManager) extends Data {

  def this() = this(null,null,null)

  var patrick: User = _
  var malte: User = _
  var daniel: User = _

  @Transactional
  def initialize() {
    val persistenceManager: PersistenceManager = identitySession.getPersistenceManager
    val roleManager: RoleManager = identitySession.getRoleManager
    val attributesManager: AttributesManager = identitySession.getAttributesManager
    val enabled: Array[Attribute] = Array(new EnabledAttribute(String.valueOf(true)).asInstanceOf[Attribute])

    patrick = persistenceManager.createUser("p_bittner@gmx.de")
    attributesManager.updatePassword(patrick, "XXXXXXX")
    attributesManager.addAttributes(patrick, enabled)
    roleManager.createRole(seamSecurity.adminRoleType, patrick, seamSecurity.userGroup)
    
    malte = persistenceManager.createUser("bruweleit_malte@team-neotech.de")
    attributesManager.updatePassword(malte, "XXXXXXX")
    attributesManager.addAttributes(malte, enabled)
    roleManager.createRole(seamSecurity.adminRoleType, malte, seamSecurity.userGroup)

    daniel = persistenceManager.createUser("contact@dwwebsites.de")
    attributesManager.updatePassword(daniel, "XXXXXXX")
    attributesManager.addAttributes(daniel, enabled)
    roleManager.createRole(seamSecurity.organiserRoleType, daniel, seamSecurity.userGroup)

  }

  def index() = 2

  def name() = "Admin"
}