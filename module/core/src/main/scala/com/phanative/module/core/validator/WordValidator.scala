package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class WordValidator
  extends ConstraintValidator[MaxWords, String] {

  private var wordCount = 0

  def initialize(constraintAnnotation: MaxWords) {
    wordCount = constraintAnnotation.length
  }

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    val incomingWords = value.replace("\n", " ").split("[\\s+]").filter(word => word != "").length
    incomingWords <= wordCount
  }

}

