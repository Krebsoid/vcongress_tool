package com.phanative.service.core.mail

import javax.inject.Inject
import org.jboss.solder.resourceLoader.ResourceProvider
import javax.enterprise.inject.Instance
import java.io.{ByteArrayInputStream, FileNotFoundException, ByteArrayOutputStream}
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.template.TemplateEngineKind
import org.apache.commons.io.IOUtils
import javax.enterprise.context.ApplicationScoped
import fr.opensagres.xdocreport.converter.{ConverterTypeVia, Options, ConverterTypeTo}
import com.phanative.model.core.person.Person
import org.jboss.solder.core.Client
import java.util
import com.phanative.startup.document.DocumentService


@ApplicationScoped
class PasswordRecoveryMailService {

  @Inject @Client var locale: Instance[util.Locale] = _

  @Inject var documentSerivce: DocumentService = _

  val documentName = "password_recovery"

  def buildHTML(person: Person, password: String, language: util.Locale): String =  {
    val localeString = locale.get()
    val document = documentSerivce.find(documentName, localeString.toString).getOrElse({
      throw new FileNotFoundException("Document with name \""+documentName+"\" and locale ("+localeString.toString+") was not found in database.")
    })
    val stream = new ByteArrayInputStream(document.data)
    val report = XDocReportRegistry.getRegistry.loadReport(stream, TemplateEngineKind.Freemarker, false)
    IOUtils.closeQuietly(stream)

    val passwordRecoveryTemplateHolder = new PasswordRecoveryMailTemplateHolder
    passwordRecoveryTemplateHolder.setFirstName(person.firstname)
    passwordRecoveryTemplateHolder.setLastName(person.lastname)
    passwordRecoveryTemplateHolder.setMail(person.identity.name)
    if(person.title != null) {
      passwordRecoveryTemplateHolder.setTitle(person.title)
    }
    else {
      passwordRecoveryTemplateHolder.setTitle("")
    }
    passwordRecoveryTemplateHolder.setGender(person.gender.name())
    passwordRecoveryTemplateHolder.setPassword(password)

    val reportContext = report.createContext()


    reportContext.put("mail", passwordRecoveryTemplateHolder)

    val out = new ByteArrayOutputStream()
    val options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM)
    report.convert(reportContext, options, out)

    out.toString("UTF8")
  }

  def testHTML(): String =  {
    val localeString = locale.get()
    val document = documentSerivce.find(documentName, localeString.toString).getOrElse({
      throw new FileNotFoundException("Document with name \""+documentName+"\" and locale ("+localeString.toString+") was not found in database.")
    })
    val stream = new ByteArrayInputStream(document.data)
    val report = XDocReportRegistry.getRegistry.loadReport(stream, TemplateEngineKind.Freemarker, false)
    IOUtils.closeQuietly(stream)

    val passwordRecoveryTemplateHolder = new PasswordRecoveryMailTemplateHolder
    passwordRecoveryTemplateHolder.setFirstName("Malte")
    passwordRecoveryTemplateHolder.setLastName("Bruweleit")
    passwordRecoveryTemplateHolder.setMail("bruweleit_malte@team-neotech.de")
    passwordRecoveryTemplateHolder.setTitle("")
    passwordRecoveryTemplateHolder.setGender("MALE")
    passwordRecoveryTemplateHolder.setPassword("asdasdasd")

    val reportContext = report.createContext()


    reportContext.put("mail", passwordRecoveryTemplateHolder)

    val out = new ByteArrayOutputStream()
    val options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM)
    report.convert(reportContext, options, out)

    out.toString("UTF8")
  }
}
