package com.phanative.startup.configuration

import javax.ws.rs.core.Application
import java.util.Set
import javax.ws.rs.ApplicationPath

@ApplicationPath("/service")
class Rest extends Application {

  override def getClasses: Set[Class[_]] = super.getClasses

  override def getSingletons: Set[AnyRef] = super.getSingletons
}


