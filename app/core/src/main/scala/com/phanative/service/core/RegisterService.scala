package com.phanative.service.core

import mail.{RegistrationMailService, Configuration}
import org.apache.commons.mail.HtmlEmail
import com.phanative.model.core.person.Person
import javax.inject.Inject
import java.util.Locale
import org.jboss.seam.transaction.Transactional
import com.phanative.module.security.model.EnabledAttribute
import org.jboss.solder.core.Client
import org.jboss.seam.security.Identity
import com.phanative.startup.configuration.Types
import org.picketlink.idm.api.{Attribute, IdentitySession, User}
import util.Random
import javax.enterprise.inject.Instance
import javax.enterprise.context.ApplicationScoped
import org.apache.commons.lang.{StringEscapeUtils, StringUtils}
import com.phanative.qualifier.MailConfiguration

@ApplicationScoped
class RegisterService @Inject()(@MailConfiguration configuration: Configuration,
                                registrationMailService: RegistrationMailService,
                                identitySession: IdentitySession,
                                identity: Identity,
                                @Client locale: Instance[Locale]) {

  def this() = this(null, null, null, null, null)

  @Transactional
  def register(username: String, password: String): User = {
    val usersGroup = identitySession.getPersistenceManager.findGroup(Types.UsersGroup, Types.GroupTypeGroup)
    val personRoleType = identitySession.getRoleManager.getRoleType(Types.personRole)
    val user = identitySession.getPersistenceManager.createUser(username)
    identitySession
      .getAttributesManager
      .updatePassword(user, password)
    identitySession
      .getRoleManager
      .createRole(personRoleType, user, usersGroup)

    identitySession
      .getAttributesManager
      .addAttributes(user, Array(new EnabledAttribute(String.valueOf(true)).asInstanceOf[Attribute]))
    user
  }

  def createPassword(): String = {
    val passwordChars = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
      'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    (1 to 8).foldLeft("")((password, character) => password + passwordChars.charAt(Random.nextInt(passwordChars.size)))
  }

  def sendRegistrationEmail(user: User, person: Person) {
    val name = person.firstname + " " + person.lastname

    val email = identity.getUser.getKey

    val htmlEmail = new HtmlEmail

    htmlEmail.setAuthentication(configuration.getLogin, configuration.getPassword)
    htmlEmail.setHostName(configuration.getHostname)

    htmlEmail.addTo(email, name)
    if (!StringUtils.equals(email, person.contact.email))
      htmlEmail.addBcc(person.contact.email, name)
    htmlEmail.setFrom(configuration.sourceMailAddress, configuration.sourceName)
    htmlEmail.setContent(null, "text/html")
    htmlEmail.setCharset("UTF8")
    htmlEmail.setSubject("Account Confirmation vCongress")

    val message = locale.get() match {
      case Locale.UK => registrationMailService.buildHTML(person)
      case Locale.GERMANY => registrationMailService.buildHTML(person)
      case _ => registrationMailService.buildHTML(person)
    }

    htmlEmail.setHtmlMsg(message)
    htmlEmail.setTextMsg(message)
    htmlEmail.send
  }


}