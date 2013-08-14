package com.phanative.model.congress

import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

object AdditionalParticipationQuery {

  case class ByParticipation(participation: Participation) extends QueryBuilder[AdditionalParticipation] {
    override def apply(builder: CriteriaBuilder,
                       query: CriteriaQuery[AdditionalParticipation],
                       root: Root[AdditionalParticipation]): CriteriaQuery[AdditionalParticipation] = {
      query.select(root)
        .where(Seq(root.get("participation").in(participation)): _*)
    }
  }

}
