package com.phanative.module.security.model.identity

import org.jboss.seam.security.annotations.management.IdentityProperty
import org.jboss.seam.security.annotations.management.PropertyType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.io.Serializable
import java.lang.Long
import reflect.BeanProperty

@Entity
class IdentityObjectCredentialType extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty var id: Long = null

  @IdentityProperty(PropertyType.NAME)
  @BeanProperty var name: String = null

}

