package com.phanative.service.core

import javax.enterprise.context.ApplicationScoped
import mail.{PasswordRecoveryMailService, Configuration}
import org.jboss.seam.transaction.Transactional
import util.Random
import org.apache.commons.mail.HtmlEmail
import java.util.Locale
import javax.inject.Inject
import com.phanative.module.persistence.service.repository.Repository
import org.jboss.solder.core.Client
import com.phanative.module.security.model.identity.IdentityObject
import com.phanative.model.core.person.{PersonQuery, Person}
import org.picketlink.idm.api.IdentitySession
import javax.enterprise.inject.Instance
import org.apache.commons.lang.{StringEscapeUtils, StringUtils}
import com.phanative.qualifier.MailConfiguration
import java.util

@ApplicationScoped
class RecoveryService @Inject()(@MailConfiguration configuration: Configuration,
                                identityRepository: Repository[IdentityObject],
                                personRepository: Repository[Person],
                                identitySession: IdentitySession,
                                passwordRecoveryMailService: PasswordRecoveryMailService,
                                @Client locale: Instance[Locale]) {

  def this() = this(null, null, null, null, null, null)


  @Transactional
  def recoverPassword(email: String) {
    val user = identitySession.getPersistenceManager.findUser(email)
    val person = personRepository.find(PersonQuery.ByEmail(email))
    val language = locale.get()

    val passwordChars = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
      'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    val randomPassword = (1 to 8).foldLeft("")((password, character) => password + passwordChars.charAt(Random.nextInt(passwordChars.size)))

    identitySession.getAttributesManager.updatePassword(user, randomPassword)

    val htmlEmail = new HtmlEmail

    htmlEmail.setAuthentication(configuration.getLogin, configuration.getPassword)
    htmlEmail.setHostName(configuration.getHostname)

    htmlEmail.setContent(null, "text/html")
    htmlEmail.setCharset("UTF8")

    htmlEmail.addTo(email)
    if (!StringUtils.equals(email, person.contact.email))
      htmlEmail.addBcc(person.contact.email)

    htmlEmail.setFrom(configuration.sourceMailAddress, configuration.sourceName)

    language match {
      case util.Locale.UK => htmlEmail.setSubject("Your data for vCongress")
      case util.Locale.GERMANY => htmlEmail.setSubject("Ihre Daten für vCongress")
      case _ => htmlEmail.setSubject("Ihre Daten für vCongress")
    }

    val message = passwordRecoveryMailService.buildHTML(person, randomPassword, language)

    htmlEmail.setHtmlMsg(message)
    htmlEmail.setTextMsg(message)
    htmlEmail.send

  }


}