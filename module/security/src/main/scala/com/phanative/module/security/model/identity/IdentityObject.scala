package com.phanative.module.security.model.identity

import com.phanative.module.persistence.model.AbstractEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import reflect.BeanProperty
import org.jboss.seam.security.annotations.management.{EntityType, IdentityEntity, IdentityProperty, PropertyType}

@Entity
@IdentityEntity(EntityType.IDENTITY_OBJECT)
class IdentityObject extends AbstractEntity {

  @BeanProperty
  @IdentityProperty(PropertyType.NAME)
  var name: String = null

  @BeanProperty
  @ManyToOne
  @JoinColumn(name = "IDENTITY_OBJECT_TYPE_ID")
  @IdentityProperty(PropertyType.TYPE)
  var objectType: IdentityObjectType = null

}



