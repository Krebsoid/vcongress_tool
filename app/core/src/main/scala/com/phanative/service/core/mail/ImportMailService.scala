package com.phanative.service.core.mail

import javax.inject.Inject
import java.io.{ByteArrayInputStream, FileNotFoundException, ByteArrayOutputStream}
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.template.TemplateEngineKind
import org.apache.commons.io.IOUtils
import javax.enterprise.context.ApplicationScoped
import fr.opensagres.xdocreport.converter.{ConverterTypeVia, Options, ConverterTypeTo}
import java.util
import com.phanative.resource.core.person.admin.ImportPersonType
import com.phanative.startup.document.DocumentService
import util.Locale


@ApplicationScoped
class ImportMailService {

  @Inject var documentSerivce: DocumentService = _

  val documentName = "person_import"

  val defaultLocale = Locale.UK

  def buildHTML(person: ImportPersonType, password: String, language: util.Locale): String =  {
    val localeString = checkForLanguage(person)
    val document = documentSerivce.find(documentName, localeString.toString).getOrElse({
      throw new FileNotFoundException("Document with name \""+documentName+"\" and locale ("+localeString.toString+") was not found in database.")
    })
    val stream = new ByteArrayInputStream(document.data)
    val report = XDocReportRegistry.getRegistry.loadReport(stream, TemplateEngineKind.Freemarker, false)
    IOUtils.closeQuietly(stream)

    val importMailTemplateHolder = new ImportMailTemplateHolder
    importMailTemplateHolder.setFirstName(person.firstname)
    importMailTemplateHolder.setLastName(person.lastname)
    if(person.title != null) {
      importMailTemplateHolder.setTitle(person.title)
    }
    else {
      importMailTemplateHolder.setTitle("")
    }
    importMailTemplateHolder.setGender(person.gender)
    if(person.gender == null) {
      importMailTemplateHolder.setGender("")
    }
    else {
      importMailTemplateHolder.setGender(person.gender)
    }
    importMailTemplateHolder.setPassword(password)

    val reportContext = report.createContext()

    reportContext.put("mail", importMailTemplateHolder)

    val out = new ByteArrayOutputStream()
    val options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM)
    report.convert(reportContext, options, out)

    out.toString("UTF8")
  }

  def checkForLanguage(person: ImportPersonType) : Locale = {
    if (person.countryCode != null) {
      person.countryCode.toLowerCase match {
        case "de" => Locale.GERMANY
        case "at" => Locale.GERMANY
        case "ch" => Locale.GERMANY
        case _ => Locale.UK
      }
    }
    else {
      defaultLocale
    }
  }

  def testHTML(): String =  {
    val localeString = "en_GB"
    val document = documentSerivce.find(documentName, localeString).getOrElse({
      throw new FileNotFoundException("Document with name \""+documentName+"\" and locale ("+localeString+") was not found in database.")
    })
    val stream = new ByteArrayInputStream(document.data)
    val report = XDocReportRegistry.getRegistry.loadReport(stream, TemplateEngineKind.Freemarker, false)
    IOUtils.closeQuietly(stream)

    val importMailTemplateHolder = new ImportMailTemplateHolder
    importMailTemplateHolder.setFirstName("Malte")
    importMailTemplateHolder.setLastName("Bruweleit")
    importMailTemplateHolder.setTitle("")
    importMailTemplateHolder.setGender("MALE")
    importMailTemplateHolder.setPassword("asdasdasd")

    val reportContext = report.createContext()

    reportContext.put("mail", importMailTemplateHolder)

    val out = new ByteArrayOutputStream()
    val options = Options.getTo(ConverterTypeTo.XHTML).via(ConverterTypeVia.ODFDOM)
    report.convert(reportContext, options, out)

    out.toString("UTF8")
  }
}
