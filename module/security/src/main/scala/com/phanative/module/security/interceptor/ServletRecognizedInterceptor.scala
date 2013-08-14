package com.phanative.module.security.interceptor

import javax.interceptor.{InvocationContext, AroundInvoke, Interceptor}
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import org.jboss.seam.security.{AuthorizationException, Identity}
import javax.persistence.EntityManager
import com.phanative.module.security.model.{ActionParam, RecognizedAction}
import javax.transaction.UserTransaction


@Recognized
@Interceptor
class ServletRecognizedInterceptor @Inject()(val entityManager: EntityManager,
                                             val userTransaction: UserTransaction,
                                             val identity: Identity,
                                             val httpRequest: HttpServletRequest) extends Serializable {

  def this() = this(null, null, null, null)

  @AroundInvoke
  def aroundInvoke(invocation: InvocationContext): AnyRef = {
    val method = invocation.getMethod

    if (method.isAnnotationPresent(classOf[Recognized])) {

      var outcome: Option[Object] = None

      var exception: Option[Exception] = None

      try {
        invocation.proceed() match {
          case result: Object => {
            outcome = Some(result)
            result
          }
          case _ => {
            outcome = None
            null
          }
        }
      }
      catch {
        case e: Exception => {
          exception = Some(e)
          throw e
        }
      }
      finally {
        val parameters = invocation.getParameters
        val recognizedAnnotation = method.getAnnotation(classOf[Recognized])
        
        exception match {
          case Some(authorizedException: AuthorizationException) => {
          }
          case Some(e: Exception) => {
          }
          case _ => {
            val recognizedAction = new RecognizedAction
            recognizedAction.username = getUsername
            recognizedAction.ip = httpRequest.getRemoteAddr

            var className = method.getDeclaringClass.getSimpleName
            if (className.endsWith("Resource")) {
              className = className.replace("Resource", "")
            }
            recognizedAction.resource = className
            recognizedAction.action = method.getName
            for(param: Param <- recognizedAnnotation.params()) {
              val actionParam = new ActionParam
              actionParam.name = param.name()
              actionParam.value = parameters(param.paramIndex()).toString
              recognizedAction.params.add(actionParam)
            }
            userTransaction.begin()
            entityManager.persist(recognizedAction)
            userTransaction.commit()
          }
        }
      }
    } else {
      invocation.proceed()
    }
  }

  def getUsername: String = {
    if (identity.isLoggedIn) {
      identity.getUser.getKey
    } else {
      "guest"
    }
  }


}
