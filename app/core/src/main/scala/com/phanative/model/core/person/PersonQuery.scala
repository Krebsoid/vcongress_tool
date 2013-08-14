package com.phanative.model.core.person

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria._
import com.phanative.module.security.model.identity.IdentityObject

object PersonQuery {
  
  case class ByIdentityObject(identityObject : IdentityObject) extends QueryBuilder[Person] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[Person], root: Root[Person]) : CriteriaQuery[Person] = {
      query.select(root)
           .where(Seq(builder.equal(root.get("identity"), identityObject)) : _*)
    }
  }

  case class ByEmail(email : String) extends QueryBuilder[Person] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[Person], root: Root[Person]) : CriteriaQuery[Person] = {
      val identityObjectPath: Path[IdentityObject] = root.get("identity")
      query.select(root)
        .where(Seq(builder.equal(identityObjectPath.get("name"), email)) : _*)
    }
  }

}