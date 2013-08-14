package com.phanative.model.core.person

import javax.persistence._
import com.phanative.module.security.model.identity.OneToIdentity
import org.joda.time.DateTime
import com.phanative.module.persistence.model.{Importable, AbstractEntity}

@Entity
class Person extends AbstractEntity with OneToIdentity with Importable {

  var title: String = ""

  @OneToOne(cascade = Array(CascadeType.ALL))
  var occupation: Occupation = new Occupation

  @OneToOne(cascade = Array(CascadeType.ALL))
  var address: Address = new Address

  @OneToOne(cascade = Array(CascadeType.ALL))
  var billAddress: BillAddress = new BillAddress

  @OneToOne(cascade = Array(CascadeType.ALL))
  var contact: Contact = new Contact

  @OneToOne(cascade = Array(CascadeType.ALL))
  var notificationOptions: NotificationOptions = new NotificationOptions

  var firstname: String = ""

  var lastname: String = ""

  @Enumerated
  var gender: Gender = _

  var birthdate: DateTime = _

}