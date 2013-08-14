package com.phanative.module.security.interceptor

import javax.interceptor.{InvocationContext, AroundInvoke, Interceptor}
import javax.inject.Inject
import org.jboss.solder.logging.Logger
import javax.servlet.http.HttpServletRequest
import org.jboss.seam.security.{AuthorizationException, Identity}
import java.lang.reflect.Method


@Logging
@Interceptor
class ServletLoggingInterceptor @Inject()(val log: Logger,
                                          val identity: Identity,
                                          val httpRequest: HttpServletRequest) extends Serializable {

  def this() = this(null, null, null)

  @AroundInvoke
  def aroundInvoke(invocation: InvocationContext): AnyRef = {
    val method = invocation.getMethod

    if (method.isAnnotationPresent(classOf[Logging])) {

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
        val logger = Logger.getLogger(method.getDeclaringClass)
        val annotation = method.getAnnotation(classOf[Logging])
        val parameters = invocation.getParameters

        val template = "%-32s %-12s %-12s %-24s IN:[%s] OUT:[%s]"

        val userAction = makeUserActionString(annotation.value(), method)

        val ipAddress = httpRequest.getRemoteAddr

        val in = makeInString(annotation, parameters)

        val out = makeOutString(annotation, outcome)

        exception match {
          case Some(authorizedException: AuthorizationException) => {
            logger.error(maxLength(
              template.format(makeUserEmailString, ipAddress, "UNAUTHORIZED", userAction, in, out)
            ))
          }
          case Some(e: Exception) => {
            logger.error(maxLength(
              template.format(makeUserEmailString, ipAddress, "ERROR", userAction, in, out)
            ))
          }
          case _ => {
            logger.info(maxLength(
              template.format(makeUserEmailString, ipAddress, "Authorized", userAction, in, out)
            ))
          }
        }
      }
    } else {
      invocation.proceed()
    }
  }

  def makeUserActionString(message: String, method: Method): String = {
    if (message.isEmpty) {
      var className = method.getDeclaringClass.getSimpleName
      if (className.endsWith("Resource")) {
        className = className.replace("Resource", "")
      }
      className + " " + method.getName
    } else {
      message
    }
  }

  def makeOutString(annotation: Logging, outcome: Option[Object]): String = {
    if (annotation.out() && outcome.isDefined) {
      outcome.get.toString
    } else {
      ""
    }
  }

  def makeInString(annotation: Logging, parameters: Array[Object]): String = {
    if (annotation.in() && !parameters.isEmpty) {
      parameters.mkString(", ")
    } else {
      ""
    }
  }

  def makeUserEmailString: String = {
    if (identity.isLoggedIn) {
      identity.getUser.getKey
    } else {
      "guest"
    }
  }

  def maxLength(string: String): String = {
    if (string.length() > 1024) {
      string.substring(0, 1024) + "..."
    } else {
      string
    }
  }


  def persistAction() {

  }


}
