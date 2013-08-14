package com.phanative.module.persistence.model

import org.jboss.solder.core.Client
import javax.inject.Inject
import java.util._
import javax.persistence._

@Entity
class LocaleString extends AbstractEntity {

  @ElementCollection
  @MapKeyColumn(name = "locale")
  @Column(name = "localizedstring")
  @CollectionTable(name = "localization")
  protected var internal: Map[Locale, String] = new HashMap[Locale, String]

  @Client
  @Inject
  @Transient
  protected var locale: Locale = _

  @Transient
  def get(): String = {
    internal.get(locale)
  }

  @Transient
  def get(locale: Locale): String = {
    internal.get(locale)
  }

  @Transient
  def add(locale: Locale, text: String): LocaleString = {
    internal.put(locale, text)
    this
  }


}
