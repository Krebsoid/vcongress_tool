package com.phanative.model.core.person

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

object ManyToPersonQuery {

  class ByPerson[ENTITY <: ManyToPerson](person: Person) extends QueryBuilder[ENTITY] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ENTITY], root: Root[ENTITY]): CriteriaQuery[ENTITY] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("person"), person)): _*)
    }
  }

  class ById[ENTITY <: ManyToPerson](person: Person, id: Long) extends QueryBuilder[ENTITY] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ENTITY], root: Root[ENTITY]): CriteriaQuery[ENTITY] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("person"), person),
                   builder.equal(root.get("id"), id)): _*)
    }
  }

  class ByPersonWithExtension[ENTITY <: ManyToPerson](person: Person,
                                                     queryBuilder: (CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY]) => CriteriaQuery[ENTITY])
    extends QueryBuilder[ENTITY] {

    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ENTITY], root: Root[ENTITY]): CriteriaQuery[ENTITY] = {
      queryBuilder(builder, query, root)

      val predicate = builder.equal(root.get("person"), person)

      if (query.getRestriction == null) {
        query.where(Seq(predicate): _*)
      } else {
        query.where(Seq(builder.and(Seq(query.getRestriction, predicate): _*)) :_*)
      }

      query.select(root)

    }

  }




}