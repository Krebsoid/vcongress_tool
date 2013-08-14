package com.phanative.startup.document

import javax.inject.Inject
import javax.persistence.EntityManager
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Document002PersonImport @Inject() (entityManager : EntityManager) extends Document {

  def this() = this(null)

  @Inject
  var documentService: DocumentService = _

  @Transactional
  def initialize() {

    documentService.find("person_import","de_DE") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "person_import"
        document.locale = "de_DE"
        document.path = "/Master/Core/import_de_DE.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }

    documentService.find("person_import","en_GB") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "person_import"
        document.locale = "en_GB"
        document.path = "/Master/Core/import_en_GB.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }
  }
}