package com.phanative.startup.scenario

import javax.enterprise.context.ApplicationScoped
import javax.persistence.criteria.CriteriaBuilder
import javax.inject.Inject
import javax.persistence.{EntityManager, NoResultException}
import org.jboss.seam.transaction.Transactional

@ApplicationScoped
class ScenarioService {

  @Inject
  var entityManager: EntityManager = _

  @Transactional
  def save(data: ScenarioEntity) {
    entityManager.merge(data)
  }

  def find(name : String) : Option[ScenarioEntity] = {
    try {
      val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
      val query = builder.createQuery(classOf[ScenarioEntity])
      val root = query.from(classOf[ScenarioEntity])
      val predicate = Array(builder.equal(root.get("name"), name))
      query.select(root)
        .where(predicate: _*)
      val typedQuery = entityManager.createQuery(query)
      Some(typedQuery.getSingleResult)
    }
    catch {
      case e:NoResultException => None
    }
  }


}