package com.phanative.service.core.person.user

import javax.inject.Inject
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import com.phanative.module.persistence.service.repository.{Internal, Repository}
import com.phanative.module.security.service.repository.OneToCurrentIdentity
import com.phanative.model.core.person.{ManyToPersonQuery, Person, ManyToPerson}
import java.io.Serializable

@Internal
class ManyToCurrentPersonImpl[ENTITY >: Null <: ManyToPerson] extends ManyToCurrentPerson[ENTITY] {

  @Inject
  protected[user] var person: OneToCurrentIdentity[Person] = _

  protected[user] var persistentClass: Class[ENTITY] = _

  protected[user] var repository: Repository[ENTITY] = _

  def find(id : Long): ENTITY = {
    repository.find(new ManyToPersonQuery.ById[ENTITY](person.find(),id))
  }

  def findAll(): List[ENTITY] = {
    repository.findAll(new ManyToPersonQuery.ByPerson[ENTITY](person.find()))
  }

  def findAll(queryBuilder: (CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY]) => CriteriaQuery[ENTITY]): List[ENTITY] = {
    repository.findAll(new ManyToPersonQuery.ByPersonWithExtension[ENTITY](person.find(), queryBuilder))
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