package com.phanative.module.persistence.producer

import org.jboss.solder.core.ExtensionManaged
import javax.enterprise.context.ConversationScoped
import javax.enterprise.inject.Produces
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceUnit

class SeamPersistenceProducer {

  @ExtensionManaged
  @Produces
  @PersistenceUnit(unitName = "vcongress")
  @ConversationScoped var producerField: EntityManagerFactory = null

}

