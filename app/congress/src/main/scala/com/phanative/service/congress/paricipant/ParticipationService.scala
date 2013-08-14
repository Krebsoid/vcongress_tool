package com.phanative.service.congress.paricipant

import javax.inject.Inject
import javax.persistence.EntityManager
import javax.enterprise.context.ApplicationScoped
import com.phanative.model.core.person.Person
import javax.enterprise.event.Observes
import com.phanative.module.persistence.service.repository.{Repository, Save}
import org.joda.time.LocalDate
import com.phanative.model.congress._

@ApplicationScoped
class ParticipationService @Inject()(participationRepository: Repository[Participation],
                                     additionalParticipationRepository: Repository[AdditionalParticipation],
                                     statusRepository: Repository[ParticipantStatus]) {

  def this() = this(null, null, null)

  def isAllInclusiveWithVIP(participation: Participation): Boolean = {
    val additionalParticipation = additionalParticipationRepository.find(AdditionalParticipationQuery.ByParticipation(participation))
    val isAllInclusive = participation.vipStatus &&
      !additionalParticipation.workshop1 &&
      !additionalParticipation.workshop2 &&
      !additionalParticipation.workshop3
    isAllInclusive
  }
}

