package com.phanative.resource.core.person.admin

import com.phanative.service.core.security.OrganizerRole
import com.phanative.module.security.interceptor.{Recognized, Logging}
import org.jboss.seam.rest.validation.ValidateRequest
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm
import com.phanative.service.core.GenderService
import scala.collection.JavaConversions._
import javax.validation.Valid
import com.phanative.module.rest.provider.extjs.model.{ResponseObject, ResponseCollection}
import javax.enterprise.context.ApplicationScoped
import com.phanative.service.core.person.admin.{PersonImportMailService, PersonImportService}
import javax.ejb.EJB
import java.util.{Locale, ArrayList}
import javax.enterprise.inject.Instance
import org.jboss.solder.core.Client
import javax.inject.Inject
import javax.ws.rs._
import core.{Context, UriInfo, MediaType, Response}
import scala.Array
import java.util
import com.phanative.service.core.mail.ImportMailService

@OrganizerRole
@Path("persons/import")
@ApplicationScoped
class PersonImportResource @Inject()(val genderService: GenderService,
                                     val personImportService: PersonImportService,
                                     val importMailService: ImportMailService,
                                     @Client val locale: Instance[util.Locale]) {

  def this() = this(null, null, null, null)

  @EJB
  var personImportMailService: PersonImportMailService = _


  @Path("submit/test")
  @GET
  def registerTest: Response = {
    val responseBuilder: Response.ResponseBuilder = Response.ok(importMailService.testHTML())
    responseBuilder.header("Content-Type", "text/html")
    responseBuilder.build
  }

  @Logging
  @Recognized
  @POST
  @Consumes(Array(MediaType.MULTIPART_FORM_DATA))
  @Produces(Array(MediaType.APPLICATION_XML))
  @ValidateRequest
  def parse(@Valid @MultipartForm importForm: ImportForm): String = {

    personImportService.importPersons(importForm.getFileExtension, importForm.importFile)

    "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><success>true</success>"
  }

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def read: ResponseCollection[ImportPersonType] = {
    val response = new ResponseCollection[ImportPersonType]
    response.data = personImportService.importedPersons.sortBy(personType => personType.row)
    response.success = true
    response
  }


  @Logging
  @Recognized
  @GET
  @Path("template")
  def template: Response = {

    val outputStream = personImportService.createImportTemplate()

    val responseBuilder: Response.ResponseBuilder = Response.ok(outputStream.toByteArray)
    responseBuilder.header("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    responseBuilder.header("Content-Disposition", "attachment; filename=\"template.xlsx\"")
    responseBuilder.build
  }

  @Logging
  @Recognized
  @DELETE
  @Produces(Array(MediaType.APPLICATION_JSON))
  def cancel: ResponseObject = {
    personImportService.importedPersons = new util.ArrayList[ImportPersonType]()
    personImportService.errorFlag = false

    new ResponseObject
  }

  @Logging
  @Recognized
  @POST
  @Path("execute")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def execute(@Context uriInfo: UriInfo): ResponseObject = {
    if(!personImportService.errorFlag) {
      personImportService.persistPersons()
      personImportMailService.notifyImportedPersons(personImportService.importedPersons, locale.get())
      personImportService.importedPersons = new util.ArrayList[ImportPersonType]()

      new ResponseObject
    }
    else {
      var response = new ResponseObject
      response.success = false
      response
    }
  }
}