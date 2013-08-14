package com.phanative.module.security.service.analyze


class AnalyzeCriteria {

  var sorted: Boolean = false
  var sorting: SortingDirection = SortingDirection.DESC

  var datePrecision: DatePrecision = _
  var year: Int = 0
  var month: Int = 0

  var resource: String = _
  var action: String = _

  var grouped: Boolean = true
  var groupingProperty = "occurDate"


  def checkForPrecision() {
    if (year == 0 && month == 0) datePrecision = DatePrecision.YEARS else
    if (year != 0 && month == 0) datePrecision = DatePrecision.MONTHS_OF_YEAR
    else datePrecision = DatePrecision.DAYS_OF_MONTH
  }

}

