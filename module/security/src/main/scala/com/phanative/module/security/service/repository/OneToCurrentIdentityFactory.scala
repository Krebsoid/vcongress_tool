package com.phanative.module.security.service.repository

import javax.enterprise.inject.Produces
import javax.enterprise.inject.spi.InjectionPoint
import com.phanative.module.security.model.identity.OneToIdentity
import com.phanative.module.persistence.model.AbstractEntity
import com.phanative.module.persistence.service.repository.{RepositoryFactory, Repository, Internal, AbstractRepositoryFactory}

class OneToCurrentIdentityFactory extends AbstractRepositoryFactory {


  @Produces
  def newInstance[E >: Null <: AbstractEntity with OneToIdentity](injectionPoint: InjectionPoint,
                                                                    @Internal oneToCurrentIdentity: OneToCurrentIdentityImpl[E],
                                                                    @Internal repository: Repository[E]): OneToCurrentIdentity[E] = {
    oneToCurrentIdentity.persistentClass = getFacadeType(injectionPoint)
    oneToCurrentIdentity.repository = RepositoryFactory.newInstance(injectionPoint, repository)
    oneToCurrentIdentity
  }

}