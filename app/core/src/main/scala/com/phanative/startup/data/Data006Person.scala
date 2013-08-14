package com.phanative.startup.data

import com.phanative.model.core.person._
import javax.inject.Inject
import javax.enterprise.context.ApplicationScoped
import com.phanative.module.persistence.service.repository.Repository
import com.phanative.module.security.service.repository.IdentityObjectManager
import javax.persistence.EntityManager
import com.phanative.module.security.model.RecognizedAction
import org.joda.time.{LocalDate, DateTime}
import org.apache.commons.net.ftp.FTPClient


@ApplicationScoped
class Data006Person @Inject()(val userImport: Data002Admin,
                              val countryImport: Data003Country,
                              val personRepository: Repository[Person],
                              val identityObjectManager: IdentityObjectManager,
                              val entityManager: EntityManager) extends Data {

  def this() = this(null, null, null, null, null)

  val patrick: Person = new Person
  val malte: Person = new Person
  val daniel: Person = new Person


  def initialize() {

    patrick.birthdate = new DateTime(1980, 4, 1, 0, 0, 0, 0)
    patrick.firstname = "Patrick"
    patrick.lastname = "Bittner"
    patrick.gender = Gender.MALE
    val patrickAddress: Address = new Address
    patrickAddress.street = "Hildesheimerstraße 84"
    patrickAddress.zipCode = "30169"
    patrickAddress.city = "Hannover"
    patrickAddress.country = countryImport.countryList.get("DE")
    val patrickBillAddress: BillAddress = new BillAddress
    patrickBillAddress.fullName = "Patrick Bittner"
    patrickBillAddress.institute = "SciSerTec GbR"
    patrickBillAddress.street = "Hildesheimerstraße 84"
    patrickBillAddress.zipCode = "30169"
    patrickBillAddress.city = "Hannover"
    patrickBillAddress.country = countryImport.countryList.get("DE")
    val patrickContact: Contact = new Contact
    patrickContact.email = "team@vcongress.de"
    patrickContact.phone = "05111054894"
    patrickContact.fax = ""
    val patrickOccupation: Occupation = new Occupation
    patrickOccupation.department = ""
    patrickOccupation.institute = "SciSerTec GbR"
    patrickOccupation.position = ""
    patrick.billAddress = patrickBillAddress
    patrick.address = patrickAddress
    patrick.contact = patrickContact
    patrick.occupation = patrickOccupation
    patrick.identity = identityObjectManager.findIdentity(userImport.patrick)
    personRepository.save(patrick)

    val recognizedAction = new RecognizedAction
    recognizedAction.resource = "Registration"
    recognizedAction.action = "register"
    recognizedAction.occurDate = new LocalDate()
    entityManager.persist(recognizedAction)

    val malteAddress: Address = new Address
    malteAddress.street = "Hildesheimerstraße 84"
    malteAddress.zipCode = "30169"
    malteAddress.city = "Hannover"
    malteAddress.country = countryImport.countryList.get("DE")
    val malteBillAddress: BillAddress = new BillAddress
    malteBillAddress.fullName = "Malte Bruweleit"
    malteBillAddress.institute = "SciSerTec GbR"
    malteBillAddress.street = "Hildesheimerstraße 84"
    malteBillAddress.zipCode = "30169"
    malteBillAddress.city = "Hannover"
    malteBillAddress.country = countryImport.countryList.get("DE")
    val malteContact: Contact = new Contact
    malteContact.email = "team@vcongress.de"
    malteContact.phone = "05111054894"
    malteContact.fax = ""
    val malteOccupation: Occupation = new Occupation
    malteOccupation.department = ""
    malteOccupation.institute = "SciSerTec GbR"
    malteOccupation.position = ""

    malte.birthdate = new DateTime(1984, 9, 25, 0, 0, 0, 0)
    malte.firstname = "Malte"
    malte.lastname = "Bruweleit"
    malte.gender = Gender.MALE

    malte.occupation = malteOccupation
    malte.address = malteAddress
    malte.billAddress = malteBillAddress
    malte.contact = malteContact
    malte.identity = identityObjectManager.findIdentity(userImport.malte)

    val recognizedAction2 = new RecognizedAction
    recognizedAction2.resource = "Registration"
    recognizedAction2.action = "register"
    recognizedAction2.occurDate = new LocalDate()
    entityManager.persist(recognizedAction2)

    personRepository.save(malte)

    val danielAddress: Address = new Address
    danielAddress.street = "Hildesheimerstraße 84"
    danielAddress.zipCode = "30169"
    danielAddress.city = "Hannover"
    danielAddress.country = countryImport.countryList.get("DE")
    val danielBillAddress: BillAddress = new BillAddress
    danielBillAddress.fullName = "Dr. Daniel Wicke"
    danielBillAddress.institute = "SciSerTec GbR"
    danielBillAddress.street = "Hildesheimerstraße 84"
    danielBillAddress.zipCode = "30169"
    danielBillAddress.city = "Hannover"
    danielBillAddress.country = countryImport.countryList.get("DE")
    val danielContact: Contact = new Contact
    danielContact.email = "team@vcongress.de"
    danielContact.phone = "05111054894"
    danielContact.fax = ""
    val danielOccupation: Occupation = new Occupation
    danielOccupation.department = ""
    danielOccupation.institute = "SciSerTec GbR"
    danielOccupation.position = ""

    daniel.birthdate = new DateTime(1978, 8, 10, 0, 0, 0, 0)
    daniel.firstname = "Daniel"
    daniel.lastname = "Wicke"
    daniel.gender = Gender.MALE
    daniel.title = "Dr."
    daniel.occupation = danielOccupation
    daniel.address = danielAddress
    daniel.billAddress = danielBillAddress
    daniel.contact = danielContact
    daniel.identity = identityObjectManager.findIdentity(userImport.daniel)

    val recognizedAction3 = new RecognizedAction
    recognizedAction3.resource = "Registration"
    recognizedAction3.action = "register"
    recognizedAction3.occurDate = new LocalDate()
    entityManager.persist(recognizedAction3)

    personRepository.save(daniel)


  }

  def index() = 6

  def name() = "Person"
}