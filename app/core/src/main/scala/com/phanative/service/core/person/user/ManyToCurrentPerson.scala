package com.phanative.service.core.person.user

import com.phanative.model.core.person.ManyToPerson
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import java.io.Serializable

trait ManyToCurrentPerson[ENTITY <: ManyToPerson] {

  def find(id: Long): ENTITY

  def findAll(): List[ENTITY]

  def findAll(queryBuilder: (CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY]) => CriteriaQuery[ENTITY]): List[ENTITY]

  def update(entity: ENTITY): ENTITY

  def save(entity: ENTITY)

  def delete(entity: ENTITY)

}