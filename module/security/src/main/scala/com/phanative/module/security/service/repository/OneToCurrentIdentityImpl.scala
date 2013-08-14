package com.phanative.module.security.service.repository

import org.jboss.seam.security.Identity
import javax.inject.Inject
import com.phanative.module.persistence.model.AbstractEntity
import com.phanative.module.security.model.identity.{IdentityObject, OneToIdentityQuery, OneToIdentity}
import com.phanative.module.persistence.service.repository.{Internal, Repository}

@Internal
class OneToCurrentIdentityImpl[ENTITY >: Null <: AbstractEntity with OneToIdentity] extends OneToCurrentIdentity[ENTITY] {

  @Inject
  protected[repository] var identity: Identity = _

  @Inject
  protected[repository] var identityObjectManager: IdentityObjectManager = _

  protected[repository] var persistentClass: Class[ENTITY] = _

  protected[repository] var repository: Repository[ENTITY] = _

  private def findIdentityObject: IdentityObject = {
    identityObjectManager.findIdentity(identity.getUser)
  }

  def find(): ENTITY = {
    repository.find(new OneToIdentityQuery.ByIdentityObject[ENTITY](findIdentityObject))
  }

  def update(entity: ENTITY): ENTITY = {
    entity.identity = findIdentityObject
    repository.update(entity)
  }

  def save(entity: ENTITY) {
    entity.identity = findIdentityObject
    repository.save(entity)
  }

  def remove(entity: ENTITY) {
    entity.identity = findIdentityObject
    repository.delete(entity)
  }

}