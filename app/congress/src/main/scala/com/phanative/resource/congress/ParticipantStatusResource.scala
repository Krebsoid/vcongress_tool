package com.phanative.resource.congress

import javax.inject.Inject
import org.joda.time.LocalDate
import com.phanative.module.persistence.service.repository.Repository
import scala.collection.JavaConversions._
import com.phanative.service.core.security.PersonRole
import javax.ws.rs.core.MediaType
import com.phanative.module.rest.provider.extjs.model.ResponseCollection
import javax.ws.rs._
import javax.enterprise.context.ApplicationScoped
import com.phanative.service.core.person.user.OneToCurrentPerson
import com.phanative.model.congress.{Participation, ParticipantStatus, ParticipantStatusQuery}

@Path("participant")
@ApplicationScoped
class ParticipantStatusResource @Inject()(repository: Repository[ParticipantStatus],
                                          participationRepository: OneToCurrentPerson[Participation]){

  def this() = this(null, null)

  @Path("status")
  @PersonRole
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readAvailable(): ResponseCollection[ParticipantStatusType] = {

    val participation = participationRepository.find()
    val statusList = repository.findAll(ParticipantStatusQuery.ByLocalDate(participation.regDate))

    val data = statusList.map(status => {
      val statusType = new ParticipantStatusType
      statusType.id = status.id
      statusType.name = status.name.get()
      statusType
    })

    val response = new ResponseCollection[ParticipantStatusType]
    response.data = data
    response
  }

  @Path("status/all")
  @PersonRole
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def readAll(): ResponseCollection[ParticipantStatusType] = {

    val statusList = repository.findAll()

    val data = statusList.map(status => {
      val statusType = new ParticipantStatusType
      statusType.id = status.id
      statusType.name = status.name.get()
      statusType
    })

    val response = new ResponseCollection[ParticipantStatusType]
    response.data = data
    response
  }

}
