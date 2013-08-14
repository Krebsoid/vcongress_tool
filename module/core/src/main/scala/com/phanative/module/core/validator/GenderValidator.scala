package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class GenderValidator
  extends ConstraintValidator[Gender, String] {

  private val genderRegEx = "((MALE|FEMALE)$)";

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    if(value != null)
      value.matches(genderRegEx)
    else
      true
  }

  def initialize(p1: Gender) {}
}

