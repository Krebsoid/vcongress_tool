package com.phanative.service.core.person.admin

import com.phanative.resource.core.person.admin.ImportPersonType
import org.apache.commons.mail.HtmlEmail
import scala.collection.JavaConversions._
import javax.ejb.{Local, Stateless, Asynchronous}
import com.phanative.service.core.mail.{ImportMailService, Configuration}
import com.phanative.qualifier.MailConfiguration
import javax.inject.Inject
import java.util

@Stateless
@Local(Array(classOf[PersonImportMailService]))
class PersonImportMailService extends Serializable {

  @Inject
  @MailConfiguration
  var configuration: Configuration = _

  @Inject
  var importMailService: ImportMailService = _

  @Asynchronous
  def notifyImportedPersons(importedPersons: util.ArrayList[ImportPersonType], locale: util.Locale) {
    importedPersons.foreach(person => sendImportMail(person, locale))
  }

  def sendImportMail(person: ImportPersonType, locale: util.Locale) {
    val name = person.firstname + " " + person.lastname
    val gender = person.gender

    // Disabled for Testversion Issues
    val email = person.email
    //val email = "support@vcongress.de"
    val password = person.password

    val htmlEmail = new HtmlEmail

    htmlEmail.setAuthentication(configuration.getLogin, configuration.getPassword)
    htmlEmail.setHostName(configuration.getHostname)

    htmlEmail.addTo(email)
    htmlEmail.setFrom(configuration.sourceMailAddress, configuration.sourceName)
    htmlEmail.setContent(null, "text/html")
    htmlEmail.setCharset("UTF8")

    locale match {
      case util.Locale.UK => htmlEmail.setSubject("Your congress registration by vCongress")
      case util.Locale.GERMANY => htmlEmail.setSubject("Ihre Kongressanmeldung durch vCongress")
      case _ => htmlEmail.setSubject("Your congress registration by vCongress")
    }

    val message = importMailService.buildHTML(person, person.password, locale)

    htmlEmail.setHtmlMsg(message)
    htmlEmail.setTextMsg(message)
    htmlEmail.send
  }

}
