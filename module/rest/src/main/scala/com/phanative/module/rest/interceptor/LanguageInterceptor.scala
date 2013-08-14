package com.phanative.module.rest.interceptor

import javax.inject.Inject
import org.jboss.solder.core.Client
import org.jboss.seam.international.Alter
import javax.enterprise.event.Event
import java.util.Locale
import org.jboss.resteasy.annotations.interception.ServerInterceptor
import org.jboss.resteasy.spi.interception.PreProcessInterceptor
import org.jboss.resteasy.spi.HttpRequest
import org.jboss.resteasy.core.{ServerResponse, ResourceMethod}
import javax.ws.rs.ext.Provider
import org.jboss.solder.logging.Logger
import org.apache.commons.lang.LocaleUtils

@Provider
@ServerInterceptor
class LanguageInterceptor extends PreProcessInterceptor {

  @Inject
  @Client
  @Alter
  var localeEvent: Event[Locale] = null

  @Inject
  var logger: Logger = null

  def preProcess(p1: HttpRequest, p2: ResourceMethod): ServerResponse = {
    try {
      if(p1.getHttpHeaders.getCookies.containsKey("lang")) {
        val locale = LocaleUtils.toLocale(p1.getHttpHeaders.getCookies.get("lang").getValue)
        localeEvent.fire(locale)
        null
      }
      null
    }
    catch {
      case e: Exception => logger.warn("No or wrong locale format was given, default language is loaded: "+ p1.getHttpHeaders.getCookies.get("lang").toString)
      localeEvent.fire(Locale.UK)
      null
    }
  }
}
