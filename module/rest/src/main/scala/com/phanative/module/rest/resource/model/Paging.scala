package com.phanative.module.rest.resource.model

import javax.ws.rs.FormParam
import java.lang.Integer

class Paging {

  @FormParam("firstResult") var firstResult: Integer = null

  @FormParam("maxResults") var maxResults: Integer = null

  def isSet = firstResult != null || maxResults != null
}

