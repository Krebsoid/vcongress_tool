package com.phanative.service.congress.organizer

import javax.inject.Inject
import javax.persistence.EntityManager
import javax.enterprise.context.ApplicationScoped
import com.phanative.model.core.person.Person
import javax.enterprise.event.Observes
import com.phanative.module.persistence.service.repository.{Repository, Save}
import org.joda.time.LocalDate
import com.phanative.model.congress._

@ApplicationScoped
class ParticipationService @Inject()(entityManager: EntityManager,
                                     participationRepository: Repository[Participation],
                                     additionalParticipationRepository: Repository[AdditionalParticipation],
                                     statusRepository: Repository[ParticipantStatus]) {

  def this() = this(null, null, null, null)

  def onPersonSave(@Observes @Save person: Person) {
    val participation = new Participation
    participation.person = person
    participation.regDate = LocalDate.now()
    participationRepository.save(participation)

    val additional = new AdditionalParticipation
    additional.status = statusRepository.find(ParticipantStatusQuery.NoParticipationStatus())
    additional.participation = participation
    additionalParticipationRepository.save(additional)
  }

}

