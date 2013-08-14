package com.phanative.startup.scenario

import javax.inject.Inject
import javax.enterprise.context.ApplicationScoped
import com.phanative.model.core.person._
import com.phanative.module.persistence.service.repository.Repository
import com.phanative.module.security.service.repository.IdentityObjectManager
import com.phanative.module.security.model.RecognizedAction
import org.joda.time.{LocalDate, DateTime}
import javax.persistence.EntityManager
import com.phanative.startup.data.Data003Country

@ApplicationScoped
class Scenario001Person @Inject()(userImport: Scenario000User,
                                  countryImport: Data003Country,
                                  personRepository: Repository[Person],
                                  val identityObjectManager: IdentityObjectManager,
                                  val entityManager: EntityManager) extends Scenario {

  def this() = this(null, null, null, null, null)

  val erna = new Person
  val admin = new Person
  val organiser = new Person
  val suborganiser = new Person
  val reviewer = new Person

  def initialize() {

    val ernaAddress: Address = new Address
    ernaAddress.street = "Nasenstraße 106"
    ernaAddress.zipCode = "38518"
    ernaAddress.city = "Gifhorn"
    ernaAddress.country = countryImport.countryList.get("DE")
    val ernaBillAddress: BillAddress = new BillAddress
    ernaBillAddress.fullName = "PD Erba Ernasen"
    ernaBillAddress.institute = "dort"
    ernaBillAddress.street = "Nasenstraße 106"
    ernaBillAddress.zipCode = "38518"
    ernaBillAddress.city = "Gifhorn"
    ernaBillAddress.country = countryImport.countryList.get("DE")
    val ernaContact: Contact = new Contact
    ernaContact.email = "placeholder@jfskjdfhkdfjg.de"
    ernaContact.fax = "123456"
    ernaContact.phone = "654321"
    val ernaOccupation: Occupation = new Occupation
    ernaOccupation.department = "hier"
    ernaOccupation.institute = "dort"
    ernaOccupation.position = "überall"

    erna.birthdate = new DateTime(1984, 9, 24, 0, 0, 0, 0)
    erna.firstname = "Erna"
    erna.lastname = "Ernasen"
    erna.gender = Gender.FEMALE
    erna.identity = identityObjectManager.findIdentity(userImport.erna)
    erna.title = "PD"
    erna.occupation = ernaOccupation
    erna.address = ernaAddress
    erna.billAddress = ernaBillAddress
    erna.contact = ernaContact

    val recognizedAction = new RecognizedAction
    recognizedAction.resource = "Registration"
    recognizedAction.action = "register"
    recognizedAction.occurDate = new LocalDate()
    entityManager.persist(recognizedAction)

    personRepository.save(erna)

    val adminAddress: Address = new Address
    adminAddress.street = "Nasenstraße 106"
    adminAddress.zipCode = "38518"
    adminAddress.city = "Gifhorn"
    adminAddress.country = countryImport.countryList.get("DE")
    val adminBillAddress: BillAddress = new BillAddress
    adminBillAddress.fullName = "PD Admin Adminnasen"
    adminBillAddress.institute = "dort"
    adminBillAddress.street = "Nasenstraße 106"
    adminBillAddress.zipCode = "38518"
    adminBillAddress.city = "Gifhorn"
    adminBillAddress.country = countryImport.countryList.get("DE")
    val adminContact: Contact = new Contact
    adminContact.email = "placeholder@jfskjdfhkdfjg.de"
    adminContact.fax = "123456"
    adminContact.phone = "654321"
    val adminOccupation: Occupation = new Occupation
    adminOccupation.department = "hier"
    adminOccupation.institute = "dort"
    adminOccupation.position = "überall"

    admin.birthdate = new DateTime(1984, 9, 24, 0, 0, 0, 0)
    admin.firstname = "Admin"
    admin.lastname = "Adminnasen"
    admin.gender = Gender.FEMALE
    admin.identity = identityObjectManager.findIdentity(userImport.admin)
    admin.title = "PD"
    admin.occupation = adminOccupation
    admin.address = adminAddress
    admin.billAddress = adminBillAddress
    admin.contact = adminContact

    val recognizedAction2 = new RecognizedAction
    recognizedAction2.resource = "Registration"
    recognizedAction2.action = "register"
    recognizedAction2.occurDate = new LocalDate()
    entityManager.persist(recognizedAction2)

    personRepository.save(admin)


    val organiserAddress: Address = new Address
    organiserAddress.street = "Nasenstraße 106"
    organiserAddress.zipCode = "38518"
    organiserAddress.city = "Gifhorn"
    organiserAddress.country = countryImport.countryList.get("DE")
    val organiserBillAddress: BillAddress = new BillAddress
    organiserBillAddress.fullName = "PD Organiser Organiser"
    organiserBillAddress.institute = "dort"
    organiserBillAddress.street = "Nasenstraße 106"
    organiserBillAddress.zipCode = "38518"
    organiserBillAddress.city = "Gifhorn"
    organiserBillAddress.country = countryImport.countryList.get("DE")
    val organiserContact: Contact = new Contact
    organiserContact.email = "placeholder@jfskjdfhkdfjg.de"
    organiserContact.fax = "123456"
    organiserContact.phone = "654321"
    val organiserOccupation: Occupation = new Occupation
    organiserOccupation.department = "hier"
    organiserOccupation.institute = "dort"
    organiserOccupation.position = "überall"

    organiser.birthdate = new DateTime(1984, 9, 24, 0, 0, 0, 0)
    organiser.firstname = "Organiser"
    organiser.lastname = "Organiser"
    organiser.gender = Gender.FEMALE
    organiser.identity = identityObjectManager.findIdentity(userImport.organiser)
    organiser.title = "PD"
    organiser.occupation = organiserOccupation
    organiser.address = organiserAddress
    organiser.billAddress = organiserBillAddress
    organiser.contact = organiserContact

    val recognizedAction3 = new RecognizedAction
    recognizedAction3.resource = "Registration"
    recognizedAction3.action = "register"
    recognizedAction3.occurDate = new LocalDate()
    entityManager.persist(recognizedAction3)

    personRepository.save(organiser)


    val suborganiserAddress: Address = new Address
    suborganiserAddress.street = "Nasenstraße 106"
    suborganiserAddress.zipCode = "38518"
    suborganiserAddress.city = "Gifhorn"
    suborganiserAddress.country = countryImport.countryList.get("DE")
    val suborganiserBillAddress: BillAddress = new BillAddress
    suborganiserBillAddress.fullName = "PD Suborganiser Suborganiser"
    suborganiserBillAddress.institute = "dort"
    suborganiserBillAddress.street = "Nasenstraße 106"
    suborganiserBillAddress.zipCode = "38518"
    suborganiserBillAddress.city = "Gifhorn"
    suborganiserBillAddress.country = countryImport.countryList.get("DE")
    val suborganiserContact: Contact = new Contact
    suborganiserContact.email = "placeholder@jfskjdfhkdfjg.de"
    suborganiserContact.fax = "123456"
    suborganiserContact.phone = "654321"
    val suborganiserOccupation: Occupation = new Occupation
    suborganiserOccupation.department = "hier"
    suborganiserOccupation.institute = "dort"
    suborganiserOccupation.position = "überall"

    suborganiser.birthdate = new DateTime(1984, 9, 24, 0, 0, 0, 0)
    suborganiser.firstname = "Suborganiser"
    suborganiser.lastname = "Suborganiser"
    suborganiser.gender = Gender.FEMALE
    suborganiser.identity = identityObjectManager.findIdentity(userImport.suborganiser)
    suborganiser.title = "PD"
    suborganiser.occupation = suborganiserOccupation
    suborganiser.address = suborganiserAddress
    suborganiser.billAddress = suborganiserBillAddress
    suborganiser.contact = suborganiserContact

    val recognizedAction5 = new RecognizedAction
    recognizedAction5.resource = "Registration"
    recognizedAction5.action = "register"
    recognizedAction5.occurDate = new LocalDate()
    entityManager.persist(recognizedAction5)

    personRepository.save(suborganiser)

    val reviewerAddress: Address = new Address
    reviewerAddress.street = "Nasenstraße 106"
    reviewerAddress.zipCode = "38518"
    reviewerAddress.city = "Gifhorn"
    reviewerAddress.country = countryImport.countryList.get("DE")
    val reviewerBillAddress: BillAddress = new BillAddress
    reviewerBillAddress.fullName = "Dipl. Ing. Reviewer Reviewer"
    reviewerBillAddress.institute = "dort"
    reviewerBillAddress.street = "Nasenstraße 106"
    reviewerBillAddress.zipCode = "38518"
    reviewerBillAddress.city = "Gifhorn"
    reviewerBillAddress.country = countryImport.countryList.get("DE")
    val reviewerContact: Contact = new Contact
    reviewerContact.email = "placeholder@jfskjdfhkdfjg.de"
    reviewerContact.fax = "123456"
    reviewerContact.phone = "654321"
    val reviewerOccupation: Occupation = new Occupation
    reviewerOccupation.department = "hier"
    reviewerOccupation.institute = "dort"
    reviewerOccupation.position = "überall"

    reviewer.birthdate = new DateTime(1984, 9, 24, 0, 0, 0, 0)
    reviewer.firstname = "Reviewer"
    reviewer.lastname = "Reviewer"
    reviewer.gender = Gender.FEMALE
    reviewer.identity = identityObjectManager.findIdentity(userImport.reviewer)
    reviewer.title = "Dipl. Ing."
    reviewer.occupation = reviewerOccupation
    reviewer.address = reviewerAddress
    reviewer.contact = reviewerContact
    reviewer.billAddress = reviewerBillAddress

    val recognizedAction4 = new RecognizedAction
    recognizedAction4.resource = "Registration"
    recognizedAction4.action = "register"
    recognizedAction4.occurDate = new LocalDate()
    entityManager.persist(recognizedAction4)

    personRepository.save(reviewer)


  }

  def index() = 1

  def name() = "PersonScenario"
}