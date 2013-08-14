package com.phanative.module.security.model

class EnabledAttribute(value: AnyRef) extends AbstractAttribute(value) {

  def getName: String = EnabledAttribute.NAME
}

object EnabledAttribute {

  val NAME: String = "enabled"

}

