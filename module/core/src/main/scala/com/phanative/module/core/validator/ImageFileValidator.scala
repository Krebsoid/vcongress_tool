package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ImageFileValidator
  extends ConstraintValidator[ImageFile, String] {

  private val imageFileRegEx = "(.*(\\.(?i)(jpg|png|gif|bmp))$)";

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    value.matches(imageFileRegEx)
  }

  def initialize(p1: ImageFile) {}
}

