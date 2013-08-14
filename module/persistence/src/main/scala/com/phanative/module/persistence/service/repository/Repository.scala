package com.phanative.module.persistence.service.repository

import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import javax.inject.Inject
import org.jboss.solder.logging.Logger
import org.jboss.seam.transaction.Transactional
import java.lang.Long
import scala.collection.JavaConversions._
import java.io.Serializable
import org.jboss.solder.beanManager.BeanManagerAware
import javax.persistence.{NoResultException, EntityManager}


@Internal
class Repository[ENTITY >: Null <: AnyRef] extends BeanManagerAware {

  @Inject
  protected var log: Logger = _

  @Inject
  protected[repository] var entityManager: EntityManager = _

  protected[repository] var persistentClass: Class[ENTITY] = _

  def findAll() : List[ENTITY] = {
    findAll((builder, query, root) => {query.select(root)})
  }

  def findAll(queryBuilder : (CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY]) => CriteriaQuery[ENTITY]) : List[ENTITY] = {
    val builder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(persistentClass)
    val root = query.from(persistentClass)
    queryBuilder(builder, query, root)
    val typedQuery = entityManager.createQuery(query)
    typedQuery.getResultList.toList
  }

  def find(queryBuilder : (CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY]) => CriteriaQuery[ENTITY]) : ENTITY = {
    val builder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(persistentClass)
    val root = query.from(persistentClass)
    queryBuilder(builder, query, root)
    val typedQuery = entityManager.createQuery(query)
    try {
      typedQuery.getSingleResult
    }
    catch {
      case e: NoResultException => {
        null
      }
    }
  }

  def count() : Int = count((builder, query, root) => {query})

  def count(queryBuilder : (CriteriaBuilder, CriteriaQuery[Long], Root[ENTITY]) => CriteriaQuery[Long]): Int = {
    val builder = entityManager.getCriteriaBuilder
    val query = builder.createQuery(classOf[Long])
    val root = query.from(persistentClass)
    val count = builder.count(root)
    query.select(count)
    queryBuilder(builder, query, root)
    val typedQuery = entityManager.createQuery(query)
    typedQuery.getSingleResult.intValue
  }

  def findById(primaryKey: Serializable) = entityManager.find(persistentClass, primaryKey)

  @Transactional
  def update(entity: ENTITY) : ENTITY = {
    val merge = entityManager.merge(entity)
    getBeanManager.fireEvent(merge, UpdateLiteral)
    merge
  }

  @Transactional
  def save(entity: ENTITY) {
    entityManager.persist(entity)
    getBeanManager.fireEvent(entity, SaveLiteral)
  }

  @Transactional
  def delete(o: AnyRef) {
    entityManager.remove(o)
    getBeanManager.fireEvent(o, DeleteLiteral)
  }

  @Transactional
  def remove(id : Serializable) : ENTITY = {
    val entity = findById(id)
    entityManager.remove(entity)
    entity
  }


}