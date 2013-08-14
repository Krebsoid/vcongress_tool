package com.phanative.module.persistence.service.repository

import javax.persistence.criteria.{Root, CriteriaQuery, CriteriaBuilder}

trait QueryBuilder[ENTITY]
  extends Function3[CriteriaBuilder, CriteriaQuery[ENTITY], Root[ENTITY], CriteriaQuery[ENTITY]]