package com.phanative.startup.document

import javax.enterprise.context.ApplicationScoped
import javax.persistence.criteria.CriteriaBuilder
import javax.inject.Inject
import javax.persistence.{PersistenceContext, EntityManager, NoResultException}
import org.jboss.seam.transaction.Transactional
import org.apache.commons.net.ftp.{FTP, FTPClient}
import org.apache.commons.io.IOUtils
import org.jboss.solder.logging.Logger

@ApplicationScoped
class DocumentService {

  private val username: String = "vcongress_docs"
  private val password: String = "s244k156"
  private val documentRepository: String = "files.scisertec.de"

  @PersistenceContext(name = "vcongress")
  var entityManager: EntityManager = _

  @Transactional
  def save(data: DocumentEntity) {
    entityManager.merge(data)
  }

  @Inject
  var logger: Logger = _

  def find(name : String, locale: String) : Option[DocumentEntity] = {
    try {
      val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
      val query = builder.createQuery(classOf[DocumentEntity])
      val root = query.from(classOf[DocumentEntity])
      query.select(root)
        .where(Seq(builder.equal(root.get("name"), name), builder.equal(root.get("locale"), locale)): _*)
      val typedQuery = entityManager.createQuery(query)
      Some(typedQuery.getSingleResult)
    }
    catch {
      case e:NoResultException => None
    }
  }

  def retrieveDocumentFromRepository(document: DocumentEntity) : Array[Byte] = {
    val f = new FTPClient()
    f.connect(documentRepository)
    f.enterLocalPassiveMode()
    f.login(username, password)
    f.setFileType(FTP.BINARY_FILE_TYPE)
    val in = f.retrieveFileStream(document.path)
    logger.info(document.path + " loaded from document repository")
    IOUtils.toByteArray(in)
  }


}