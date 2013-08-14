package com.phanative.module.security.service.repository

import com.phanative.module.persistence.model.AbstractEntity
import com.phanative.module.security.model.identity.OneToIdentity

trait OneToCurrentIdentity[ENTITY <: AbstractEntity with OneToIdentity] {

  def find(): ENTITY

  def update(entity: ENTITY) : ENTITY

  def save(entity: ENTITY)

  def remove(entity: ENTITY)

}