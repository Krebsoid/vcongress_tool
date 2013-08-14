package com.phanative.module.rest.resource

import javax.inject.Inject
import javax.ws.rs._
import javax.ws.rs.core.MediaType
import javax.enterprise.context.ApplicationScoped
import com.phanative.module.rest.provider.extjs.model.ResponseCollection
import com.phanative.module.security.service.ActionAnalyzer
import com.phanative.module.security.service.analyze.{AnalyzeCriteria, AnalyzeType}
import com.phanative.module.security.interceptor.Logging

@ApplicationScoped
@Path("stat")
class StatisticResource @Inject()(val actionAnalyzer: ActionAnalyzer) {

  def this() = this(null)

  @Logging
  @GET
  @Path("{resource}/{method}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getStat(@PathParam("resource") resource: String,  
              @PathParam("method") method: String,
              @QueryParam("year") @DefaultValue("0") year: Int, 
              @QueryParam("month") @DefaultValue("0") month: Int): ResponseCollection[AnalyzeType] = {

    val analyzeCriteria = new AnalyzeCriteria
    analyzeCriteria.year = year
    analyzeCriteria.month = month
    analyzeCriteria.resource = resource
    analyzeCriteria.action = method

    val analyzeResults = actionAnalyzer.getResults(analyzeCriteria)

    val response = new ResponseCollection[AnalyzeType]
    response.success = true
    response.data = analyzeResults
    response
  }
}

