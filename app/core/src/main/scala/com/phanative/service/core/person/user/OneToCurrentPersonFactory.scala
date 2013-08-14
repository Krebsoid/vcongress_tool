package com.phanative.service.core.person.user

import javax.enterprise.inject.Produces
import javax.enterprise.inject.spi.InjectionPoint
import com.phanative.model.core.person.OneToPerson
import com.phanative.module.persistence.service.repository.{RepositoryFactory, Repository, Internal, AbstractRepositoryFactory}

object OneToCurrentPersonFactory extends AbstractRepositoryFactory {

  @Produces
  def newInstance[E >: Null <: OneToPerson](injectionPoint: InjectionPoint,
                                    @Internal oneToCurrentPerson: OneToCurrentPersonImpl[E],
                                    @Internal repository: Repository[E]): OneToCurrentPerson[E] = {
    oneToCurrentPerson.persistentClass = getFacadeType(injectionPoint)
    oneToCurrentPerson.repository = RepositoryFactory.newInstance(injectionPoint, repository)
    oneToCurrentPerson
  }

}