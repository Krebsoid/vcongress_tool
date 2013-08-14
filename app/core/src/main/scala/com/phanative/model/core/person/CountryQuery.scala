package com.phanative.model.core.person

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria._
import com.phanative.module.security.model.identity.IdentityObject

object CountryQuery {
  
  case class ByIsoCode(isoCode : String) extends QueryBuilder[Country] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[Country], root: Root[Country]) : CriteriaQuery[Country] = {
      query.select(root)
           .where(Seq(builder.equal(root.get("isoCode"), isoCode)) : _*)
    }
  }

}