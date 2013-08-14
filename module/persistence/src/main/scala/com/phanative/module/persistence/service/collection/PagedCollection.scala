package com.phanative.module.persistence.service.collection

import java.util.Collection

trait PagedCollection[E] extends Collection[E] {

  var total : Int = 0

}