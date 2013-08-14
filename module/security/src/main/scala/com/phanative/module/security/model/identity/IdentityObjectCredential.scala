package com.phanative.module.security.model.identity

import javax.persistence._
import java.io.Serializable
import java.lang.Long
import reflect.BeanProperty
import org.jboss.seam.security.annotations.management.{EntityType, IdentityEntity, IdentityProperty, PropertyType}

@Entity
@IdentityEntity(EntityType.IDENTITY_CREDENTIAL)
class IdentityObjectCredential extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = null

  @ManyToOne
  @JoinColumn(name = "IDENTITY_OBJECT_ID")
  @BeanProperty
  var identityObject: IdentityObject = null

  @ManyToOne
  @IdentityProperty(PropertyType.TYPE)
  @JoinColumn(name = "CREDENTIAL_TYPE_ID")
  @BeanProperty
  var credentialType: IdentityObjectCredentialType = null

  @IdentityProperty(PropertyType.VALUE)
  @BeanProperty
  var value: String = null


}

