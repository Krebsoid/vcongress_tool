package com.phanative.module.persistence.service

import criteria.{FilterType, SortType, GroupType}
import scala.collection.mutable.{HashMap, Map}
import java.util.List

class EntityCriteria {

  var sorted: Boolean = false
  var sortByName: List[SortType] = null
  var ascending: Boolean = true
  var paged: Boolean = false
  var firstResult: Int = 0
  var maxResults: Int = 10
  var filters: List[FilterType] = null
  var filtered: Boolean = false
  var grouped: Boolean = false
  var group: List[GroupType] = null
  final val attributes: Map[String, Array[String]] = new HashMap[String, Array[String]]

}

