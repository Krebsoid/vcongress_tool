package com.phanative.module.security.model.identity

import org.jboss.seam.security.annotations.permission.PermissionProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull
import java.io.Serializable
import org.jboss.seam.security.annotations.permission.PermissionPropertyType._
import java.lang.Long
import reflect.BeanProperty

@Entity 
class IdentityPermission extends Serializable {

  @Id
  @GeneratedValue
  @BeanProperty var id: Long = null

  @NotNull
  @ManyToOne
  @PermissionProperty(IDENTITY)
  @BeanProperty var identityObject: IdentityObject = null

  @ManyToOne
  @PermissionProperty(RELATIONSHIP_TYPE)
  @BeanProperty var relationshipType: IdentityObjectRelationshipType = null

  @PermissionProperty(RELATIONSHIP_NAME)
  @BeanProperty var relationshipName: String = null

  @PermissionProperty(RESOURCE)
  @BeanProperty var resource: String = null

  @PermissionProperty(PERMISSION)
  @BeanProperty var permission: String = null
  
}

