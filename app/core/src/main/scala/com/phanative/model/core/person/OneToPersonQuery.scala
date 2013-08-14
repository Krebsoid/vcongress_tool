package com.phanative.model.core.person

import com.phanative.module.persistence.service.repository.QueryBuilder
import collection.Seq
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

object OneToPersonQuery {

  class ByPerson[ENTITY <: OneToPerson](person: Person) extends QueryBuilder[ENTITY] {
    
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ENTITY], root: Root[ENTITY]): CriteriaQuery[ENTITY] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("person"), person)): _*)
    }
    
  }

}