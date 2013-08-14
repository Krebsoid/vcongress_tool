package com.phanative.module.persistence.interceptor

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import java.util.Map
import collection.JavaConversions._
import org.jboss.weld.context.bound.{BoundSessionContext, BoundConversationContext, BoundRequestContext, MutableBoundRequest}

@ApplicationScoped
class VirtualConversation @Inject()(conversationContext: BoundConversationContext,
                                    requestContext: BoundRequestContext,
                                    sessionContext: BoundSessionContext){

  def this() = this(null, null, null)

  def begin() {
    val requestMap: Map[String, AnyRef] = collection.mutable.Map[String, AnyRef]()
    val sessionMap: Map[String, AnyRef] = collection.mutable.Map[String, AnyRef]()
    sessionContext.associate(sessionMap)
    sessionContext.activate()
    requestContext.associate(requestMap)
    requestContext.activate()
    conversationContext.associate(new MutableBoundRequest(requestMap, sessionMap))
    conversationContext.activate()
  }

  def end() {
    conversationContext.invalidate()
    conversationContext.deactivate()
    requestContext.invalidate()
    requestContext.deactivate()
    sessionContext.invalidate()
    sessionContext.deactivate()
  }

}

