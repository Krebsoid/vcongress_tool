package com.phanative.module.rest.oberserver

import org.apache.commons.lang.StringUtils
import org.jboss.solder.servlet.event.Destroyed
import org.jboss.solder.servlet.event.Initialized
import org.jboss.solder.servlet.event.Path
import org.jboss.weld.context.http.Http
import org.jboss.weld.context.http.HttpConversationContext
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ConversationObserver @Inject()(@Http context: HttpConversationContext) {

  def this() = this(null)

  def onRequestInitialise(@Observes @Initialized @Path("service") servletRequest: HttpServletRequest) {
    val cid: String = servletRequest.getHeader("cid")
    if (cid != null) {
      if (StringUtils.isNotEmpty(cid)) {
        context.activate(cid)
      }
    }
    else {
      context.activate()
    }
  }

  def onResponseDestroyed(@Observes @Destroyed @Path("service") servletResponse: HttpServletResponse) {
    context.invalidate()
    context.deactivate()
  }


}

