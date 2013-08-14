package com.phanative.startup.configuration

import javax.enterprise.inject.Produces
import org.jboss.seam.international.timezone.DefaultTimeZone

class Timezone {

  @Produces
  @DefaultTimeZone
  val defaultTimeZoneId = "Europe/Amsterdam"

}