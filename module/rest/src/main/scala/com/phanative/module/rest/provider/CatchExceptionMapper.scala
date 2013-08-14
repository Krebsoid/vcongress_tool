package com.phanative.module.rest.provider

import javax.ws.rs.core.Response
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Event
import javax.inject.Inject
import javax.enterprise.inject.Instance
import org.jboss.seam.rest.exceptions.{RestResource, RestRequest}
import org.jboss.solder.exception.control._
import javax.ws.rs.ext.{Provider, ExceptionMapper}

@Provider
@ApplicationScoped
class CatchExceptionMapper extends ExceptionMapper[Throwable] {

  @Inject
  @RestResource
  var response: Instance[Response] = null

  @Inject
  var bridgeEvent: Event[ExceptionToCatch] = null

  override def toResponse(exception: Throwable): Response = {
    val payload = new ExceptionToCatch(exception, RestRequest.RestRequestLiteral.INSTANCE)
    bridgeEvent.fire(payload)
    response.get
  }

}

