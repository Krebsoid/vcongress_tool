package com.phanative.module.security.model.identity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.io.Serializable
import java.lang.Long
import reflect.BeanProperty
import org.jboss.seam.security.annotations.management.{EntityType, IdentityEntity}

@Entity
@IdentityEntity(EntityType.IDENTITY_ROLE_NAME)
class IdentityRoleName extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty var id: Long = null

  @BeanProperty var name: String = null


}

