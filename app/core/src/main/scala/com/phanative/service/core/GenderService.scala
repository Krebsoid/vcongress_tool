package com.phanative.service.core

import javax.enterprise.context.ApplicationScoped
import com.phanative.model.core.person.Gender


@ApplicationScoped
class GenderService {

  def findAll() = Gender.values().toList

  def find(id : Int) = Gender.values()(id-1)

  def id(gender : Gender) = Gender.values().indexOf(gender) + 1

}