package com.phanative.module.security.service.repository

import javax.enterprise.context.ApplicationScoped
import org.jboss.seam.security.Identity
import com.phanative.module.security.model.identity.IdentityObject
import collection.JavaConversions._
import javax.inject.Inject
import javax.persistence.EntityManager
import org.picketlink.idm.api.{User, Group, IdentityType, IdentitySession}

@ApplicationScoped
class IdentityObjectManager {

  @Inject
  var entityManager: EntityManager = _

  @Inject
  var identitySession : IdentitySession = _


  def findIdentitiesByName(identityNames : Set[String]) : Set[IdentityObject] = {
    val builder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(classOf[IdentityObject])
    val root = query.from(classOf[IdentityObject])
    query.select(root)
      .where(Seq(root.get("name").in(identityNames : java.util.Set[String])) : _*)
      .select(root)
    val typedQuery = entityManager.createQuery(query)
    typedQuery.getResultList.toSet
  }

  def findIdentities(identity : Identity) : Set[IdentityObject] = {
    val identityNames = identity.getGroups.map(group => group.getName) + identity.getUser.getId
    findIdentitiesByName(identityNames.toSet)
  }

  def findIdentities(identityTypes : Set[IdentityType]) : Set[IdentityObject] = {
    findIdentitiesByName(identityTypes.map(identityType => identityType match {
      case user : User => user.getId
      case group : Group => group.getName
    }))
  }


  def findIdentity(name : String) : IdentityObject = {
    val builder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(classOf[IdentityObject])
    val root = query.from(classOf[IdentityObject])
    query.select(root)
      .where(Seq(builder.equal(root.get("name"), name)) : _*)
      .select(root)
    val typedQuery = entityManager.createQuery(query)
    typedQuery.getSingleResult
  }

  def findIdentity(user : User) : IdentityObject = findIdentity(user.getId)

  def findIdentity(group : Group) : IdentityObject = findIdentity(group.getName)

  def findIdentity(identity : Identity) : IdentityObject = findIdentity(identity.getUser.getKey)

  def findIdentityType(identityObject: IdentityObject) : IdentityType = identityObject match {
    case i if i.getObjectType().getName() == "GROUP" => {
      identitySession.getPersistenceManager.findGroup(i.getName(), i.getObjectType().getName())
    }
    case i if i.getObjectType().getName() == "USER" => {
      identitySession.getPersistenceManager.findUser(i.getName())
    }
  }


}