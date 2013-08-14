package com.phanative.resource.core.person.admin

import javax.ws.rs.FormParam
import org.jboss.resteasy.annotations.providers.multipart.PartType
import com.phanative.module.core.validator.ExcelFile

class ImportForm {

  @FormParam("personImport")
  @PartType("application/octet-stream")
  var importFile: Array[Byte] = Array[Byte]()

  @FormParam("fileName")
  @ExcelFile
  var fileName: String = null

  def getFileExtension: String = fileName.split("[.]").last

}
