package com.phanative.service.core.security

import org.jboss.seam.security.annotations.Secures
import org.jboss.seam.security.Identity

import com.phanative.startup.configuration.Types._
import javax.inject.Inject

class Restrictions {

  @Inject
  var identity: Identity = _

  @Secures
  @LoggedOut
  def isLoggedOut: Boolean = identity.getUser == null

  @Secures
  @AdministratorRole
  def isAdministrator: Boolean = identity.hasRole(adminRole, UsersGroup, GroupTypeGroup)

  @Secures
  @OrganizerRole
  def isOrganizer: Boolean = identity.hasRole(subOrganiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(organiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(adminRole, UsersGroup, GroupTypeGroup)

  @Secures
  @ReviewerRole
  def isReviewer: Boolean = identity.hasRole(reviewerRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(subOrganiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(organiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(adminRole, UsersGroup, GroupTypeGroup)

  @Secures
  @PersonRole
  def isPerson: Boolean = identity.hasRole(personRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(reviewerRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(subOrganiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(organiserRole, UsersGroup, GroupTypeGroup) ||
    identity.hasRole(adminRole, UsersGroup, GroupTypeGroup)


}