package com.phanative.service.core.mail

import reflect.BeanProperty
import org.jboss.solder.core.Veto


@Veto
class Configuration {

  @BeanProperty var hostname: String = null
  @BeanProperty var login: String = null
  @BeanProperty var password: String = null

  @BeanProperty var sourceMailAddress: String = null
  @BeanProperty var sourceName: String = null
}

