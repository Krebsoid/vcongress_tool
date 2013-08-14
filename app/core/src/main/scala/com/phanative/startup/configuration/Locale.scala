package com.phanative.startup.configuration

import javax.enterprise.inject.Produces
import org.jboss.seam.international.locale.DefaultLocale

class Locale{

  @Produces
  @DefaultLocale
  val defaultLocaleKey = "en_GB"

}