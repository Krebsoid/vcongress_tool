package com.phanative.module.security.model.identity

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import org.jboss.seam.security.Identity
import org.picketlink.idm.api.User

object IdentityObjectQuery {

  case class ByName(name : String) extends QueryBuilder[IdentityObject] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[IdentityObject], root: Root[IdentityObject]) : CriteriaQuery[IdentityObject] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("name"), name)) : _*)
    }
  }

  case class ByIdentity(identity : Identity) extends QueryBuilder[IdentityObject] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[IdentityObject], root: Root[IdentityObject]) : CriteriaQuery[IdentityObject] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("name"), identity.getUser.getKey)) : _*)
    }
  }

  case class ByUser(user : User) extends QueryBuilder[IdentityObject] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[IdentityObject], root: Root[IdentityObject]) : CriteriaQuery[IdentityObject] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("name"), user.getKey)) : _*)
    }
  }




}