package com.phanative.module.rest

import javax.enterprise.context.ApplicationScoped
import org.jboss.solder.exception.control._
import org.jboss.seam.rest.validation.ValidationException
import org.jboss.seam.rest.exceptions.{RestResource, RestRequest}
import javax.ws.rs.core.Response
import javax.validation.ConstraintViolation
import provider.extjs.model.ResponseValidationException
import scala.collection.JavaConversions._
import javax.inject.Inject
import org.jboss.solder.logging.Logger
import com.phanative.module.security.service.LoginException
import org.jboss.seam.security.AuthorizationException

@HandlesExceptions
@ApplicationScoped
class RestExceptionHandlers {

  @Inject
  var log: Logger = _

  def handleException(@Handles(precedence = Precedence.LOW, during = TraversalMode.DEPTH_FIRST)
                      @RestRequest event: CaughtException[Exception],
                      @RestResource builder: Response.ResponseBuilder) {
    builder.status(Response.Status.INTERNAL_SERVER_ERROR)
    val exception = event.getException
    builder.entity("Whhooops!")
    event.handled()

    log.error(exception.getMessage, exception)
  }

  def handleLoginException(@Handles(precedence = Precedence.DEFAULT, during = TraversalMode.DEPTH_FIRST)
                           @RestRequest event: CaughtException[LoginException],
                           @RestResource builder: Response.ResponseBuilder) {
    builder.status(Response.Status.FORBIDDEN)
    event.handled()
  }

  def handleUnauthorizedException(@Handles(precedence = Precedence.DEFAULT, during = TraversalMode.DEPTH_FIRST)
                                  @RestRequest event: CaughtException[AuthorizationException],
                                  @RestResource builder: Response.ResponseBuilder) {
    builder.status(Response.Status.FORBIDDEN)
    event.handled()
  }

  def handleValidationException(@Handles(precedence = Precedence.DEFAULT, during = TraversalMode.DEPTH_FIRST)
                                @RestRequest event: CaughtException[ValidationException],
                                @RestResource builder: Response.ResponseBuilder) {
    val violations: Set[ConstraintViolation[AnyRef]] = event.getException.getViolations.toSet
    builder.status(Response.Status.OK)

    val violationsMap = violations.map(violation => {
      val field = new ResponseValidationException.Field
      field.id = violation.getPropertyPath.toString
      field.msg = violation.getMessage
      field
    })

    val message = new ResponseValidationException
    message.errors = violationsMap.toList

    builder.entity(message)
    event.handled()
  }

}