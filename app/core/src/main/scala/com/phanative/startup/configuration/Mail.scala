package com.phanative.startup.configuration

import javax.enterprise.inject.Produces
import com.phanative.service.core.mail.Configuration
import com.phanative.qualifier.MailConfiguration

class Mail {

  @MailConfiguration
  @Produces
  def produce(): Configuration = {
    val configuration = new Configuration

    configuration.hostname = "smtp.1und1.de"
    configuration.login = "noreply@sciser.net"
    configuration.password = "XXXXXXXXX"

    configuration.sourceName = "vCongress Support"
    configuration.sourceMailAddress = "support@vcongress.de"

    configuration
  }

}