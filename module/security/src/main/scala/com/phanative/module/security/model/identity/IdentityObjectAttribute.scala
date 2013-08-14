package com.phanative.module.security.model.identity

import javax.persistence._
import java.io.Serializable
import reflect.BeanProperty
import java.lang.Integer
import org.jboss.seam.security.annotations.management.{IdentityEntity, EntityType, IdentityProperty, PropertyType}

@Entity
@IdentityEntity(EntityType.IDENTITY_ATTRIBUTE)
class IdentityObjectAttribute extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty var attributeId: Integer = null
  
  @ManyToOne
  @JoinColumn(name = "IDENTITY_OBJECT_ID") 
  @BeanProperty var identityObject: IdentityObject = null
  
  @IdentityProperty(PropertyType.NAME) 
  @BeanProperty var name: String = null
  
  @IdentityProperty(PropertyType.VALUE)
  @BeanProperty var value: String = null

}

