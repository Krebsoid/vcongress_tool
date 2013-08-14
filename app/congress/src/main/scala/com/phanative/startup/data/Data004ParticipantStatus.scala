package com.phanative.startup.data

import javax.inject.Inject
import org.jboss.seam.transaction.Transactional
import javax.enterprise.context.ApplicationScoped
import java.util.Locale
import org.joda.time.LocalDate
import com.phanative.model.congress.ParticipantStatus
import com.phanative.module.persistence.service.repository.Repository
import javax.persistence.EntityManager

@ApplicationScoped
class Data004ParticipantStatus @Inject()(status: Repository[ParticipantStatus],
                                         entityManager: EntityManager) extends Data {

  def this() = this(null, null)

  val noParticipation: ParticipantStatus = new ParticipantStatus
  val staff: ParticipantStatus = new ParticipantStatus
  val vip: ParticipantStatus = new ParticipantStatus

  val cat1: ParticipantStatus = new ParticipantStatus
  val cat2: ParticipantStatus = new ParticipantStatus
  val cat3: ParticipantStatus = new ParticipantStatus

  val cat4: ParticipantStatus = new ParticipantStatus
  val cat5: ParticipantStatus = new ParticipantStatus
  val cat6: ParticipantStatus = new ParticipantStatus

  @Transactional
  def initialize() {

    noParticipation.name
      .add(Locale.GERMANY, "Keine Teilnahme")
      .add(Locale.UK, "No Participation")
    noParticipation.begin = new LocalDate(2012, 3, 3)
    noParticipation.end = new LocalDate(2014, 8, 31)
    noParticipation.noParticipation = true
    noParticipation.choosable = false
    status.save(noParticipation)

    staff.name
      .add(Locale.GERMANY, "Mitarbeiter")
      .add(Locale.UK, "Staff")
    staff.begin = new LocalDate(2012, 3, 3)
    staff.end = new LocalDate(2014, 8, 31)
    staff.choosable = false
    status.save(staff)

    vip.name
      .add(Locale.GERMANY, "VIP Status")
      .add(Locale.UK, "VIP Status")
    vip.begin = new LocalDate(2012, 3, 3)
    vip.end = new LocalDate(2014, 8, 31)
    vip.vip = true
    vip.choosable = false
    status.save(vip)

    cat1.name
      .add(Locale.GERMANY, "Teilnehmer Status 1 (Fruehbucher)")
      .add(Locale.UK, "Participation Status 1 (early bird)")
    cat1.begin = new LocalDate(2012, 3, 3)
    cat1.end = new LocalDate(2013, 5, 5)
    status.save(cat1)

    cat2.name
      .add(Locale.GERMANY, "Teilnehmer Status 2 (Fruehbucher)")
      .add(Locale.UK, "Participation Status 2 (early bird)")
    cat2.begin = new LocalDate(2012, 3, 3)
    cat2.end = new LocalDate(2013, 5, 5)
    status.save(cat2)

    cat3.name
      .add(Locale.GERMANY, "Teilnehmer Status 3 (Fruehbucher)")
      .add(Locale.UK, "Participation Status 3 (early bird)")
    cat3.begin = new LocalDate(2012, 3, 3)
    cat3.end = new LocalDate(2013, 5, 5)
    status.save(cat3)

    cat4.name
      .add(Locale.GERMANY, "Teilnehmer Status 1")
      .add(Locale.UK, "Participation Status 1")
    cat4.begin = new LocalDate(2013, 5, 5)
    cat4.end = new LocalDate(2014, 8, 31)
    status.save(cat4)

    cat5.name
      .add(Locale.GERMANY, "Teilnehmer Status 2")
      .add(Locale.UK, "Participation Status 2")
    cat5.begin = new LocalDate(2013, 5, 5)
    cat5.end = new LocalDate(2014, 8, 31)
    status.save(cat5)

    cat6.name
      .add(Locale.GERMANY, "Teilnehmer Status 3")
      .add(Locale.UK, "Participation Status 3")
    cat6.begin = new LocalDate(2013, 5, 5)
    cat6.end = new LocalDate(2014, 8, 31)
    status.save(cat6)

  }

  def index() = 4

  def name() = "ParticipantStatus"
}