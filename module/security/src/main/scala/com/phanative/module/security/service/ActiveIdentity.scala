package com.phanative.module.security.service

import javax.inject.Inject
import org.picketlink.idm.api._
import javax.enterprise.context.ApplicationScoped
import java.util.Set
import org.picketlink.idm.impl.api.PasswordCredential
import org.jboss.seam.security.{Credentials, Identity}

@ApplicationScoped
class ActiveIdentity @Inject()(identity: Identity,
                               identitySession: IdentitySession,
                               credentials: Credentials) extends Serializable {

  def this() = this(null, null, null)

  def login(username: String, password: String): Set[Role] = {
    val user = identitySession.getPersistenceManager.findUser(username)
    if (user == null) {
      throw new LoginException
    } else {
      credentials.setUsername(username)
      credentials.setCredential(new PasswordCredential(password))
      identity.login()
      if (identity.isLoggedIn) {
        identity.getRoles
      } else {
        throw new LoginException
      }
    }
  }

  def update(username: String, password: String, newPassword: String): User = {
    val user = identity.getUser
    val isPasswordValid = identitySession.getAttributesManager.validatePassword(user, password);

    if (isPasswordValid && user.getKey.equals(username)) {
      identitySession.getAttributesManager.updatePassword(user, newPassword)
      identitySession.save()
    }
    else {
      throw new LoginException
    }
    user
  }


}

