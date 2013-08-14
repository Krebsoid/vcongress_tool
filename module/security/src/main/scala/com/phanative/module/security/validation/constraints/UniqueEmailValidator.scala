package com.phanative.module.security.validation.constraints

import org.picketlink.idm.api.IdentitySession
import org.picketlink.idm.api.PersistenceManager
import org.picketlink.idm.common.exception.IdentityException
import javax.inject.Inject
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import org.apache.commons.lang.StringUtils

class UniqueEmailValidator @Inject()(identitySession: IdentitySession)
  extends ConstraintValidator[UniqueEmail, String] {

  def this() = this(null)

  private var persistenceManager: PersistenceManager = null

  def initialize(constraintAnnotation: UniqueEmail) {
    persistenceManager = identitySession.getPersistenceManager
  }

  def isValid(value: String, context: ConstraintValidatorContext): Boolean = {
    try {
      persistenceManager.findUser(StringUtils.lowerCase(value)) == null
    }
    catch {
      case e: IdentityException => {
        false
      }
    }
  }

}

