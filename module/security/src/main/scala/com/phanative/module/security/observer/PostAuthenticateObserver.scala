package com.phanative.module.security.observer

import com.phanative.module.security.model.EnabledAttribute
import org.jboss.seam.security.Credentials
import org.jboss.seam.security.Identity
import org.jboss.seam.security.events.PostAuthenticateEvent
import org.picketlink.idm.api.Attribute
import org.picketlink.idm.api.AttributesManager
import org.picketlink.idm.api.IdentitySession
import org.picketlink.idm.api.User
import javax.enterprise.event.Observes
import javax.inject.Inject
import java.lang.Boolean

class PostAuthenticateObserver @Inject()(identity: Identity,
                                         credentials: Credentials,
                                         identitySession: IdentitySession) {

  def this() = this(null,null,null)

  def onPostAuthenticate(@Observes event: PostAuthenticateEvent) {

    val user: User = identity.getUser
    val attributesManager: AttributesManager = identitySession.getAttributesManager
    val attribute: Attribute = attributesManager.getAttribute(user, EnabledAttribute.NAME)
    val enabled: Boolean = new Boolean(attribute.getValue.asInstanceOf[String])
    if (!enabled) {
      identity.logout()
    }

  }

}

