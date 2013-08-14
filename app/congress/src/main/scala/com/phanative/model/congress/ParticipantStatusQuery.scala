package com.phanative.model.congress

import org.joda.time.LocalDate
import com.phanative.module.persistence.service.repository.QueryBuilder
import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

object ParticipantStatusQuery {

  case class ByLocalDate(date: LocalDate) extends QueryBuilder[ParticipantStatus] {

    def apply(builder: CriteriaBuilder,
              query: CriteriaQuery[ParticipantStatus],
              root: Root[ParticipantStatus]): CriteriaQuery[ParticipantStatus] = {
      query
        .select(root)
        .where(Seq(
        builder.lessThanOrEqualTo(root.get("begin"), date),
        builder.greaterThanOrEqualTo(root.get("end"), date),
        builder.equal(root.get("noParticipation"), false),
        builder.equal(root.get("choosable"), true)): _*)
    }

  }

  case class NoParticipationStatus() extends QueryBuilder[ParticipantStatus] {
    def apply(builder: CriteriaBuilder, query: CriteriaQuery[ParticipantStatus], root: Root[ParticipantStatus]): CriteriaQuery[ParticipantStatus] = {
      query.select(root)
        .where(Seq(builder.equal(root.get("noParticipation"), true)): _*)
    }
  }

}
