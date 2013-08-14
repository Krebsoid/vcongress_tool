package com.phanative.module.security.model.identity

import javax.persistence._
import java.io.Serializable
import java.lang.Long
import reflect.BeanProperty
import org.jboss.seam.security.annotations.management.{EntityType, IdentityEntity, IdentityProperty, PropertyType}

@Entity
@IdentityEntity(EntityType.IDENTITY_RELATIONSHIP)
class IdentityObjectRelationship extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty var id: Long = null

  @IdentityProperty(PropertyType.NAME)
  @BeanProperty var name: String = null

  @ManyToOne
  @IdentityProperty(PropertyType.TYPE)
  @JoinColumn(name = "RELATIONSHIP_TYPE_ID")
  @BeanProperty var relationshipType: IdentityObjectRelationshipType = null

  @ManyToOne
  @IdentityProperty(PropertyType.RELATIONSHIP_FROM)
  @JoinColumn(name = "FROM_IDENTITY_ID")
  @BeanProperty var from: IdentityObject = null

  @ManyToOne
  @IdentityProperty(PropertyType.RELATIONSHIP_TO)
  @JoinColumn(name = "TO_IDENTITY_ID")
  @BeanProperty var to: IdentityObject = null

}

