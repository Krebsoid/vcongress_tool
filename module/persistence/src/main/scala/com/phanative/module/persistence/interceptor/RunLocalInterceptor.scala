package com.phanative.module.persistence.interceptor

import javax.inject.Inject
import javax.interceptor.AroundInvoke
import javax.interceptor.Interceptor
import javax.interceptor.InvocationContext
import java.io.Serializable

@Interceptor
@RunLocal
class RunLocalInterceptor  @Inject() (virtualConversation: VirtualConversation) extends Serializable {

  def this() = this(null)

  @AroundInvoke
  def aroundInvoke(invocation: InvocationContext): AnyRef = {
    var proceed: AnyRef = null
    virtualConversation.begin()
    proceed = invocation.proceed
    virtualConversation.end()
    proceed
  }


}

