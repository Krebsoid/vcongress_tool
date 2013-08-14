package com.phanative.module.persistence.service.repository

import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}
import com.phanative.module.persistence.model.AbstractEntity

class DefaultQueryBuilder extends QueryBuilder[AbstractEntity] {
  def apply(v1: CriteriaBuilder, v2: CriteriaQuery[AbstractEntity], v3: Root[AbstractEntity]) = v2
}