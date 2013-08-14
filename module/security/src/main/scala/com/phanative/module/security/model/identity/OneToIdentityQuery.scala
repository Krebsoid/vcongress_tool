package com.phanative.module.security.model.identity

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

object OneToIdentityQuery {

  class ByIdentityObject[ENTITY <: OneToIdentity](identityObject : IdentityObject) extends QueryBuilder[ENTITY] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ENTITY], root: Root[ENTITY]) : CriteriaQuery[ENTITY] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("identity"), identityObject)) : _*)
    }
  }


}