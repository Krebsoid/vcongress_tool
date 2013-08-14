package com.phanative.module.persistence.service.repository

import javax.enterprise.inject.spi.InjectionPoint
import java.lang.reflect.ParameterizedType

trait AbstractRepositoryFactory {

  protected def getFacadeType[E](injectionPoint: InjectionPoint): Class[E] = {
    val genericType = injectionPoint.getType
    if (genericType.isInstanceOf[ParameterizedType]) {
      val parameterizedType = genericType.asInstanceOf[ParameterizedType]
      parameterizedType.getActualTypeArguments.head.asInstanceOf[Class[E]]
    }
    else {
      throw new IllegalStateException("TYPE_PARAMETER_MUST_BE_CONCRETE")
    }
  }

  protected def newInstance[E](aClass: Class[E]): E = {
    try {
      aClass.newInstance
    }
    catch {
      case e: Exception => {
        throw new RuntimeException(e)
      }
    }
  }

}