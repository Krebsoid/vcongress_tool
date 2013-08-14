package com.phanative.module.core.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class FileSizeValidator
  extends ConstraintValidator[FileSize, Array[Byte]] {

  private var fileSize = 0

  def initialize(constraintAnnotation: FileSize) {
    fileSize = constraintAnnotation.length
  }

  def isValid(value: Array[Byte], context: ConstraintValidatorContext): Boolean = {
    val actualFileSize = value.size
    actualFileSize <= fileSize
  }

}

