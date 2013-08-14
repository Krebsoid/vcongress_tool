package com.phanative.startup

import document.Document
import javax.enterprise.inject.Instance
import javax.inject.Inject
import scala.collection.JavaConversions._
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DocumentManager {

  @Inject
  var data: Instance[Document] = _

  def execute() {
    val documentList = data
      .iterator()
      .toList

    documentList.foreach((data: Document) => {
        data.initialize()
    })
  }


}