package com.phanative.startup.document

import javax.inject.Inject
import javax.persistence.EntityManager
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Document000Registration @Inject() (entityManager : EntityManager) extends Document {

  def this() = this(null)

  @Inject
  var documentService: DocumentService = _

  @Transactional
  def initialize() {

    documentService.find("registration","de_DE") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "registration"
        document.locale = "de_DE"
        document.path = "/Master/Core/registration_de_DE.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }

    documentService.find("registration","en_GB") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "registration"
        document.locale = "en_GB"
        document.path = "/Master/Core/registration_en_GB.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }
  }
}