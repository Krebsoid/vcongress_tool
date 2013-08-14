package com.phanative.service.core.person.user

import javax.enterprise.inject.Produces
import javax.enterprise.inject.spi.InjectionPoint
import com.phanative.model.core.person.ManyToPerson
import com.phanative.module.persistence.service.repository.{RepositoryFactory, Repository, Internal, AbstractRepositoryFactory}

object ManyToCurrentPersonFactory extends AbstractRepositoryFactory {

  @Produces
  def newInstance[E >: Null <: ManyToPerson](injectionPoint: InjectionPoint,
                                     @Internal manyToCurrentPerson: ManyToCurrentPersonImpl[E],
                                     @Internal repository: Repository[E]): ManyToCurrentPerson[E] = {
    manyToCurrentPerson.persistentClass = getFacadeType(injectionPoint)
    manyToCurrentPerson.repository = RepositoryFactory.newInstance(injectionPoint, repository)
    manyToCurrentPerson
  }

}