package com.phanative.module.security.model

import org.picketlink.idm.api.Attribute
import java.util.Collection
import java.util.LinkedList
import java.util.List
import collection.JavaConversions._

abstract class AbstractAttribute(val values: List[AnyRef]) extends Attribute {

  def this(value : AnyRef) = {
    this(new LinkedList[AnyRef])
    values add value
  }

  def getValue: AnyRef = values.headOption.getOrElse(null)

  def addValue(value: AnyRef) { values add value }

  def getValues: Collection[_] = values

  def getSize: Int = values.size


}

