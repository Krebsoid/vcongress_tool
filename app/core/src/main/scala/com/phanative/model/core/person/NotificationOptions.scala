package com.phanative.model.core.person

import javax.persistence.Entity
import com.phanative.module.persistence.model.AbstractEntity

@Entity
class NotificationOptions extends AbstractEntity{

  var commonNewsletter: Boolean = false

}
