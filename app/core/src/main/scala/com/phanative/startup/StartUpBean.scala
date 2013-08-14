package com.phanative.startup

import javax.enterprise.event.Observes
import org.jboss.solder.servlet.event.Started
import org.jboss.solder.servlet.WebApplication
import com.phanative.module.persistence.interceptor.RunLocal
import javax.inject.{Inject, Singleton}
import javax.activation.{CommandMap, MailcapCommandMap}
import org.apache.commons.lang.builder.{ToStringStyle, ToStringBuilder}

@Singleton
class StartUpBean {

  @Inject
  var dataManager: DataManager = _

  @Inject
  var documentManager: DocumentManager = _

  @Inject
  var scenarioManager: ScenarioManager = _

  @RunLocal
  def onWebApplicationStarted(@Observes @Started application: WebApplication) {
    val mc: MailcapCommandMap = CommandMap.getDefaultCommandMap.asInstanceOf[MailcapCommandMap]
    mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html")
    mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml")
    mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain")
    mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed")
    mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822")
    CommandMap.setDefaultCommandMap(mc)

    ToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE)

    dataManager.execute()
    documentManager.execute()
    scenarioManager.execute()
  }

}