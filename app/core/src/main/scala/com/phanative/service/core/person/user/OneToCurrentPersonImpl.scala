package com.phanative.service.core.person.user

import javax.inject.Inject
import com.phanative.model.core.person.{OneToPersonQuery, Person, OneToPerson}
import com.phanative.module.security.service.repository.OneToCurrentIdentity
import com.phanative.module.persistence.service.repository.{Repository, Internal}

@Internal
class OneToCurrentPersonImpl[ENTITY >: Null <: OneToPerson] extends OneToCurrentPerson[ENTITY] {

  @Inject
  protected[user] var person: OneToCurrentIdentity[Person] = _

  protected[user] var persistentClass: Class[ENTITY] = _

  protected[user] var repository: Repository[ENTITY] = _

  def find(): ENTITY = {
    repository.find(new OneToPersonQuery.ByPerson[ENTITY](person.find()))
  }

  def update(entity: ENTITY): ENTITY = {
    entity.person = person.find()
    repository.update(entity)
  }

  def save(entity: ENTITY) {
    entity.person = person.find()
    repository.save(entity)
  }

  def delete(entity: ENTITY) {
    entity.person = person.find()
    repository.delete(entity)
  }


}