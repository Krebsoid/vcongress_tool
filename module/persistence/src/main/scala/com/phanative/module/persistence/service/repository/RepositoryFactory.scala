package com.phanative.module.persistence.service.repository

import javax.enterprise.inject.Produces
import javax.enterprise.inject.spi.InjectionPoint

object RepositoryFactory extends AbstractRepositoryFactory {

  @Produces
  def newInstance[E >: Null <: AnyRef](injectionPoint: InjectionPoint,
                                            @Internal repository: Repository[E]): Repository[E] = {
    repository.persistentClass = getFacadeType(injectionPoint)
    repository
  }


}