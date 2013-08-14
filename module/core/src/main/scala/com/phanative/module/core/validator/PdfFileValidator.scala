package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PdfFileValidator
  extends ConstraintValidator[PdfFile, String] {

  private val excelFileRegEx = "(.*(\\.(?i)(pdf))$)"

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    value.matches(excelFileRegEx)
  }

  def initialize(p1: PdfFile) {}
}

