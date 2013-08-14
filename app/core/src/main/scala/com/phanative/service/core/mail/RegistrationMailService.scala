package com.phanative.service.core.mail

import javax.inject.Inject
import javax.enterprise.inject.Instance
import java.io.{FileNotFoundException, ByteArrayInputStream, ByteArrayOutputStream}
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
class RegistrationMailService {

  @Inject @Client var locale: Instance[util.Locale] = _

  @Inject var documentSerivce: DocumentService = _

  val documentName = "registration"

  def buildHTML(person: Person): String =  {
    val localeString = locale.get()
    val document = documentSerivce.find(documentName, localeString.toString).getOrElse({
      throw new FileNotFoundException("Document with name \""+documentName+"\" and locale ("+localeString.toString+") was not found in database.")
    })
    val stream = new ByteArrayInputStream(document.data)
    val report = XDocReportRegistry.getRegistry.loadReport(stream, TemplateEngineKind.Freemarker, false)
    IOUtils.closeQuietly(stream)

    val registrationTemplateHolder = new RegistrationMailTemplateHolder
    registrationTemplateHolder.setFirstName(person.firstname)
    registrationTemplateHolder.setLastName(person.lastname)
    registrationTemplateHolder.setMail(person.identity.name)
    if(person.title != null) {
      registrationTemplateHolder.setTitle(person.title)
    }
    else {
      registrationTemplateHolder.setTitle("")
    }
    registrationTemplateHolder.setGender(person.gender.name())

    val reportContext = report.createContext()

    reportContext.put("mail", registrationTemplateHolder)

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

    val registrationTemplateHolder = new RegistrationMailTemplateHolder
    registrationTemplateHolder.setFirstName("Malte")
    registrationTemplateHolder.setLastName("Bruweleit")
    registrationTemplateHolder.setMail("bruweleit_malte@team-neotech.de")
    registrationTemplateHolder.setTitle("Prof.")
    registrationTemplateHolder.setGender("FEMALE")

    val reportContext = report.createContext()

    reportContext.put("mail", registrationTemplateHolder)

    val out = new ByteArrayOutputStream()
    val options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM)
    report.convert(reportContext, options, out)

    out.toString("UTF8")
  }
}
