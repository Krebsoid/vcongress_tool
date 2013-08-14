package com.phanative.service.core.person.admin

import org.jboss.solder.exception.control._
import javax.inject.Inject
import org.jboss.solder.logging.Logger
import org.hibernate.validator.method.MethodConstraintViolationException
import com.phanative.resource.core.person.admin.{ErrorType, ImportPersonType}
import scala.collection.JavaConversions._
import java.util.ArrayList
import org.jboss.seam.rest.exceptions.{RestResource, RestRequest}
import javax.ws.rs.core.Response
import javax.enterprise.context.SessionScoped

@HandlesExceptions
@SessionScoped
class PersonImportExceptionHandlers extends Serializable{

  @Inject
  var personImportService: PersonImportService = null

  def handleException(@Handles(precedence = Precedence.LOW, during = TraversalMode.DEPTH_FIRST)
                      @RestRequest event: CaughtException[MethodConstraintViolationException],
                      @RestResource builder: Response.ResponseBuilder) {

    builder.status(Response.Status.INTERNAL_SERVER_ERROR)

    val exception = event.getException
    val erroneousPersonTypes = new ArrayList[ImportPersonType]()
    exception.getConstraintViolations.foreach(violation => {

      val errorType = new ErrorType
      errorType.msg = violation.getMessage
      errorType.field = violation.getPropertyPath.last.toString.toLowerCase.capitalize
      errorType.value = {
        if(violation.getInvalidValue.isInstanceOf[String])
          violation.getInvalidValue.asInstanceOf[String]
        else
          ""
      }

      if (erroneousPersonTypes.exists(personType => personType == violation.getLeafBean.asInstanceOf[ImportPersonType])) {
        val personType = erroneousPersonTypes.find(personType => personType == violation.getLeafBean.asInstanceOf[ImportPersonType]).get
        personType.errors.add(errorType)
      }
      else {
        val personType = violation.getLeafBean.asInstanceOf[ImportPersonType]
        personType.erroneous = true
        personType.errors.add(errorType)
        erroneousPersonTypes.add(personType)
      }
    })
    personImportService.errorFlag = true
    personImportService.importedPersons = erroneousPersonTypes

    event.handled()
  }

}