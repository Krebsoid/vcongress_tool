package com.phanative.startup.data

import javax.inject.Inject
import javax.persistence.EntityManager
import com.phanative.module.security.model.identity.{IdentityObjectRelationshipType, IdentityObjectCredentialType, IdentityObjectType}
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped

/**
 * @author: Patrick Bittner
 */

@ApplicationScoped
class Data000IdentityObject @Inject() (entityManager : EntityManager) extends Data {

  def this() = this(null)

  @Transactional
  def initialize() {

    val userType = new IdentityObjectType
    userType.name = "USER"
    entityManager.persist(userType)

    val groupType = new IdentityObjectType
    groupType.name = "GROUP"
    entityManager.persist(groupType)

    val passwordCredentialType = new IdentityObjectCredentialType
    passwordCredentialType.name = "PASSWORD"
    entityManager.persist(passwordCredentialType)

    val membershipRelationshipType = new IdentityObjectRelationshipType
    membershipRelationshipType.name = "JBOSS_IDENTITY_MEMBERSHIP"
    entityManager.persist(membershipRelationshipType)

    val roleRelationshipType = new IdentityObjectRelationshipType
    roleRelationshipType.name = "JBOSS_IDENTITY_ROLE"
    entityManager.persist(roleRelationshipType)

  }

  def index() = 0

  def name() = "IdentityObject"
}