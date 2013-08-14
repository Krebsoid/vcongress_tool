package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ExcelFileValidator
  extends ConstraintValidator[ExcelFile, String] {

  private val excelFileRegEx = "(.*(\\.(?i)(xls|xlsx))$)";

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    value.matches(excelFileRegEx)
  }

  def initialize(p1: ExcelFile) {}
}

