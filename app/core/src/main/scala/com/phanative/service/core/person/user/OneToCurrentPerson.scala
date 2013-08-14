package com.phanative.service.core.person.user

import com.phanative.model.core.person.OneToPerson


trait OneToCurrentPerson[ENTITY <: OneToPerson] {

  def find(): ENTITY

  def update(entity: ENTITY): ENTITY

  def save(entity: ENTITY)

  def delete(entity: ENTITY)

}