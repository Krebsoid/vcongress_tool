package com.phanative.model.congress

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import com.phanative.model.core.person.Person

object ParticipationQuery {

  case class ByPerson(person: Person) extends QueryBuilder[Participation] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[Participation], root: Root[Participation]): CriteriaQuery[Participation] = {
      query
        .select(root)
        .where(Seq(builder.equal(root.get("person"), person)): _*)
    }
  }

}