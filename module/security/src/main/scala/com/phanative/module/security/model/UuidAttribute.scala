package com.phanative.module.security.model

class UuidAttribute(value: AnyRef) extends AbstractAttribute(value) {

  def getName: String = UuidAttribute.NAME

}

object  UuidAttribute {

  val NAME: String = "uuid"

}

