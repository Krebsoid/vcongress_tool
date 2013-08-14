package com.phanative.module.core.validator

import javax.validation.MessageInterpolator
import java.lang.String
import javax.validation.MessageInterpolator.Context
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator
import org.jboss.solder.beanManager.BeanManagerAware
import org.jboss.solder.literal.ClientLiteral
import java.util.{Set, Locale}
import javax.enterprise.inject.spi.Bean


class I18nMessageInterpolator extends BeanManagerAware with MessageInterpolator {

  val delegate: ResourceBundleMessageInterpolator = new ResourceBundleMessageInterpolator

  var clientLocaleBean: Bean[_ <: Locale] = null
  
  def interpolate(messageTemplate: String, context: Context): String = {
    if (clientLocaleBean == null) {
      clientLocaleBean = createClientLocaleBean()
    }
    delegate.interpolate(messageTemplate, context, createClientLocaleInstance)
  }

  def interpolate(messageTemplate: String, context: Context, locale: Locale): String = {
    if (clientLocaleBean == null) {
      clientLocaleBean = createClientLocaleBean()
    }
    delegate.interpolate(messageTemplate, context, createClientLocaleInstance)
  }

  def createClientLocaleInstance: Locale = {
    val ctx = getBeanManager.createCreationalContext(clientLocaleBean)
    val locale = getBeanManager.getReference(clientLocaleBean, classOf[Locale], ctx).asInstanceOf[Locale]
    locale
  }

  def createClientLocaleBean() : Bean[_ <: Locale] = {
    if (!isBeanManagerAvailable) {
      throw new IllegalStateException("No bean manager is available. In order to use I18nMessageInterpolator, the javax.validation.Validator " + "must either be retrieved via dependency injection or a bean manager must be available via JNDI.")
    }

    val beanManager = getBeanManager
    val localeClass = classOf[Locale]
    val beans = beanManager.getBeans(localeClass, ClientLiteral.INSTANCE).asInstanceOf[Set[Bean[_ <: Locale]]]

    if (!beans.isEmpty) {
      beanManager.resolve[Locale](beans)
    }
    else {
      throw new IllegalStateException("No User Locale found")
    }
  }
}