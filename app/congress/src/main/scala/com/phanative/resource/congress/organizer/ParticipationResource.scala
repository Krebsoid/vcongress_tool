package com.phanative.resource.congress.organizer

import org.jboss.seam.rest.validation.ValidateRequest
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs._
import javax.ws.rs.core.MediaType
import com.phanative.module.persistence.service.repository.Repository
import javax.enterprise.context.ApplicationScoped
import com.phanative.model.congress._
import com.phanative.module.security.interceptor.{Recognized, Logging}
import com.phanative.module.rest.provider.extjs.model.{ResponseCollection, ResponseData}
import com.phanative.service.core.security.OrganizerRole
import com.phanative.resource.congress.participant.ParticipationType
import com.phanative.resource.congress.EventTicketCountType
import scala.collection.JavaConversions._

@OrganizerRole
@ApplicationScoped
@Path("participant")
class ParticipationResource @Inject()(val participantStatusRepository: Repository[ParticipantStatus],
                                      val participationRepository: Repository[Participation],
                                      val additionalParticipationRepository: Repository[AdditionalParticipation]) {

  def this() = this(null, null, null)


  @Logging
  @GET
  @Path("participation/admin/{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readByOrganizer(@PathParam("id") participationId: Long): ResponseData[ParticipationType] = {
    val participation = participationRepository.findById(participationId)
    val additionalParticipation = additionalParticipationRepository.find(AdditionalParticipationQuery.ByParticipation(participation))

    val participationType = new ParticipationType
    participationType.id = participation.id
    participationType.participationStatusId = additionalParticipation.status.id
    participationType.participationStatusIdFixed = additionalParticipation.statusFixed
    participationType.workshop1 = additionalParticipation.workshop1
    participationType.workshop1Fixed = additionalParticipation.workshop1Fixed
    participationType.workshop2 = additionalParticipation.workshop2
    participationType.workshop2Fixed = additionalParticipation.workshop2Fixed
    participationType.workshop3 = additionalParticipation.workshop3
    participationType.workshop3Fixed = additionalParticipation.workshop3Fixed
    participationType.eveningEventTickets = additionalParticipation.eveningEventTickets
    participationType.eveningEventTicketsFixed = additionalParticipation.eveningEventTicketsFixed
    participationType.eveningEventTicketsMax = additionalParticipation.eveningEventTicketsMax
    participationType.dirty = additionalParticipation.workshop1Fixed ||
      additionalParticipation.workshop2Fixed ||
      additionalParticipation.workshop3Fixed ||
      additionalParticipation.eveningEventTicketsFixed > 0 ||
      additionalParticipation.statusFixed
    participationType.vipStatus = participation.vipStatus

    val response = new ResponseData[ParticipationType]
    response.success = true
    response.data = participationType
    response
  }

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Path("participation/admin/{id}/eventtickets")
  def getEventTicketStore(@PathParam("id") participationId: Long): ResponseCollection[EventTicketCountType] = {
    val participation = participationRepository.findById(participationId)
    val additionalParticipation = additionalParticipationRepository.find(AdditionalParticipationQuery.ByParticipation(participation))

    val maxTickets = additionalParticipation.eveningEventTicketsMax
    val fixedTickets = additionalParticipation.eveningEventTicketsFixed

    val result = (fixedTickets to maxTickets)
      .map(x => {val countType = new EventTicketCountType; countType.id = x; countType}).toList

    val response = new ResponseCollection[EventTicketCountType]
    response.data = result
    response.success = true
    response
  }

  @Logging
  @Recognized
  @PUT
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @ValidateRequest
  @Path("participation/admin/{id}")
  def updateByOrganizer(@Valid participationType: ParticipationType, @PathParam("id") participationId: Long): ResponseData[ParticipationType] = {

    val participantStatus = participantStatusRepository.findById(participationType.participationStatusId)
    val participation = participationRepository.findById(participationId)
    val additionalParticipation = additionalParticipationRepository.find(AdditionalParticipationQuery.ByParticipation(participation))

    if(!additionalParticipation.statusFixed) {
      additionalParticipation.status = participantStatus
    }
    if(!additionalParticipation.workshop1Fixed) {
      additionalParticipation.workshop1 = participationType.workshop1
    }
    if(!additionalParticipation.workshop2Fixed) {
      additionalParticipation.workshop2 = participationType.workshop2
    }
    if(!additionalParticipation.workshop3Fixed) {
      additionalParticipation.workshop3 = participationType.workshop3
    }
    if(additionalParticipation.eveningEventTicketsMax >= participationType.eveningEventTickets) {
      additionalParticipation.eveningEventTickets = participationType.eveningEventTickets
    }
    additionalParticipationRepository.update(additionalParticipation)

    val response = new ResponseData[ParticipationType]
    response.data = participationType
    response.success = true
    response
  }
}

