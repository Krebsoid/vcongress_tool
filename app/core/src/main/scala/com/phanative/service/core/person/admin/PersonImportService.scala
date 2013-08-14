package com.phanative.service.core.person.admin

import java.util.ArrayList
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import javax.validation.Valid
import org.jboss.seam.validation.AutoValidating
import javax.enterprise.context.SessionScoped
import org.apache.poi.ss.usermodel.Cell
import scala.collection.JavaConversions._
import com.phanative.model.core.person.{CountryQuery, Country, Gender, Person}
import com.phanative.service.core.RegisterService
import javax.inject.Inject
import com.phanative.module.persistence.service.repository.Repository
import com.phanative.module.security.model.identity.{IdentityObject, IdentityObjectQuery}
import java.io.{ByteArrayOutputStream, ByteArrayInputStream}
import com.phanative.module.security.model.RecognizedAction
import org.joda.time.LocalDate
import javax.persistence.EntityManager
import com.phanative.resource.core.person.admin.ImportPersonType
import javax.faces.bean.RequestScoped
import org.apache.commons.lang.StringUtils

@SessionScoped
class PersonImportService @Inject()(val registerService: RegisterService,
                                    val identityObjectRepository: Repository[IdentityObject],
                                    val personService: Repository[Person],
                                    val countryRepository: Repository[Country],
                                    val entityManager: EntityManager) extends Serializable {

  def this() = this(null, null, null, null, null)

  var errorFlag = false
  var importedPersons = new ArrayList[ImportPersonType]()

  @RequestScoped
  var collectionImporterCheck = new ArrayList[ImportPersonType]()

  @AutoValidating @Valid def importPersons(fileExtension: String,  importFile: Array[Byte]) : ArrayList[ImportPersonType] = {
    val stream = new ByteArrayInputStream(importFile)
    val importWorkbook = fileExtension match {
      case "xls" => new HSSFWorkbook(stream)
      case "xlsx" => new XSSFWorkbook(stream)
    }
    val userSheet = importWorkbook.getSheetAt(0)
    val rowIterator = userSheet.rowIterator()
    rowIterator.next()
    var filledRows = 0
    while (rowIterator.hasNext) {
      val row = rowIterator.next()
      try {
        var tempRowNumber = row.getCell(0).getNumericCellValue.toInt
        if(tempRowNumber > 0)
          filledRows = tempRowNumber
      } catch { case _ => {} }
    }

    val personList = new ArrayList[ImportPersonType]()

    for(i <- 1 to filledRows) {
      val row = userSheet.getRow(i)
      val person = new ImportPersonType

      person.row = i
      person.lastname = try { row.getCell(1).getStringCellValue } catch { case _ =>  "" }
      person.firstname = try { row.getCell(2).getStringCellValue } catch { case _ =>  "" }

      person.title = try { row.getCell(3).getStringCellValue } catch { case _ =>  "" }
      person.gender = try {
        row.getCell(4).getStringCellValue.toUpperCase match {
          case "MALE" => "MALE"
          case "FEMALE" => "FEMALE"
          case _ => null
        }
      } catch { case _ =>  null }

      person.street = try { row.getCell(5).getStringCellValue } catch { case _ =>  "" }
      person.zipCode = try {row.getCell(6).setCellType(Cell.CELL_TYPE_STRING); row.getCell(6).getStringCellValue } catch { case _ =>  "" }
      person.city = try { row.getCell(7).getStringCellValue } catch { case _ =>  "" }
      person.country = try {
        val parsedCountry = StringUtils.upperCase(row.getCell(8).getStringCellValue)
        val country = countryRepository.find(CountryQuery.ByIsoCode(parsedCountry)).name.get()
        person.countryCode = parsedCountry
        country
      } catch { case _ =>  "" }

      person.email = try {
        StringUtils.trim(StringUtils.lowerCase(row.getCell(9).getStringCellValue))
      } catch { case _ =>  "" }
      person.phone = try {row.getCell(10).setCellType(Cell.CELL_TYPE_STRING); row.getCell(10).getStringCellValue } catch { case _ =>  "" }
      person.fax = try {row.getCell(11).setCellType(Cell.CELL_TYPE_STRING); row.getCell(11).getStringCellValue } catch { case _ =>  "" }

      person.institute = try { row.getCell(12).getStringCellValue } catch { case _ =>  "" }
      person.department = try { row.getCell(13).getStringCellValue } catch { case _ =>  "" }
      person.position = try { row.getCell(14).getStringCellValue } catch { case _ =>  "" }

      personList.add(person)
    }

    errorFlag = false
    importedPersons = personList
    markDuplicates(personList)
  }

  def persistPersons() {
    importedPersons.foreach((personType) => {
      val person = new Person
      person.imported = true
      person.firstname = personType.firstname
      person.lastname = personType.lastname
      if(personType.gender != null) {
        person.gender = Gender.valueOf(personType.gender)
      }
      else {
        person.gender = Gender.NO_GENDER
      }
      person.title = personType.title

      person.address.street = personType.street
      person.address.zipCode = personType.zipCode
      person.address.city = personType.city
      person.address.country = countryRepository.find(CountryQuery.ByIsoCode(personType.countryCode))

      person.billAddress.fullName = personType.title + " " + personType.firstname + " " + personType.lastname
      person.billAddress.institute = personType.institute
      person.billAddress.street = personType.street
      person.billAddress.zipCode = personType.zipCode
      person.billAddress.city = personType.city
      person.billAddress.country = countryRepository.find(CountryQuery.ByIsoCode(personType.countryCode))

      person.contact.email = StringUtils.lowerCase(personType.email)
      person.contact.phone = personType.phone
      person.contact.fax = personType.fax

      person.occupation.institute = personType.institute
      person.occupation.department = personType.department
      person.occupation.position = personType.position

      personType.password = registerService.createPassword()

      val user = registerService.register(StringUtils.lowerCase(personType.email), personType.password)
      val identityObject = identityObjectRepository.find(IdentityObjectQuery.ByUser(user))

      person.identity = identityObject
      personService.save(person)

      val recognizedAction = new RecognizedAction
      recognizedAction.resource = "Registration"
      recognizedAction.action = "register"
      recognizedAction.occurDate = new LocalDate()
      entityManager.persist(recognizedAction)
    })
  }

  def createImportTemplate(): ByteArrayOutputStream = {
    val template = new XSSFWorkbook()
    val sheet = template.createSheet("vCongress Participant Import")
    val firstRow = sheet.createRow(0)
    firstRow.createCell(0).setCellValue("#")
    firstRow.createCell(1).setCellValue("Nachname")
    firstRow.createCell(2).setCellValue("Vorname")
    firstRow.createCell(3).setCellValue("Titel")
    firstRow.createCell(4).setCellValue("Geschlecht (male/female)")
    firstRow.createCell(5).setCellValue("Straße")
    firstRow.createCell(6).setCellValue("PLZ")
    firstRow.createCell(7).setCellValue("Stadt")
    firstRow.createCell(8).setCellValue("Land als Country Code")
    firstRow.createCell(9).setCellValue("E-Mail Adresse")
    firstRow.createCell(10).setCellValue("Telefon")
    firstRow.createCell(11).setCellValue("Fax")
    firstRow.createCell(12).setCellValue("Institut")
    firstRow.createCell(13).setCellValue("Abteilung")
    firstRow.createCell(14).setCellValue("Position")

    val secondRow = sheet.createRow(1)
    secondRow.createCell(0).setCellValue(1)

    sheet.autoSizeColumn(0)
    sheet.autoSizeColumn(1)
    sheet.autoSizeColumn(2)
    sheet.autoSizeColumn(3)
    sheet.autoSizeColumn(4)
    sheet.autoSizeColumn(5)
    sheet.autoSizeColumn(6)
    sheet.autoSizeColumn(7)
    sheet.autoSizeColumn(8)
    sheet.autoSizeColumn(9)
    sheet.autoSizeColumn(10)
    sheet.autoSizeColumn(11)
    sheet.autoSizeColumn(12)
    sheet.autoSizeColumn(13)
    sheet.autoSizeColumn(14)

    val outputStream = new ByteArrayOutputStream()

    template.write(outputStream)
    outputStream
  }

  private def markDuplicates(incomingList: ArrayList[ImportPersonType]) : ArrayList[ImportPersonType] = {
    val notUniqueSet = incomingList.groupBy(personType => personType.email).filter(entry => entry._2.size > 1).keySet
    incomingList.foreach(personType => {
      if(notUniqueSet.exists(entry => entry.contains(personType.email))) {
        personType.duplicate = true
      }
    })
    incomingList
  }

}
