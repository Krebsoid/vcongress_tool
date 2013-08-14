package com.phanative.startup.document

import javax.inject.Inject
import javax.persistence.EntityManager
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Document001PasswordRecovery @Inject() (entityManager : EntityManager) extends Document {

  def this() = this(null)

  @Inject
  var documentService: DocumentService = _

  @Transactional
  def initialize() {

    documentService.find("password_recovery","de_DE") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "password_recovery"
        document.locale = "de_DE"
        document.path = "/Master/Core/password_recovery_de_DE.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }

    documentService.find("password_recovery","en_GB") match {
      case Some(document) => {
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.merge(document)
      }
      case None => {
        val document = new DocumentEntity
        document.name = "password_recovery"
        document.locale = "en_GB"
        document.path = "/Master/Core/password_recovery_en_GB.odt"
        document.data = documentService.retrieveDocumentFromRepository(document)
        entityManager.persist(document)
      }
    }
  }
}