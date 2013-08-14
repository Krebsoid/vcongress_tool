package com.phanative.module.rest

import javax.ws.rs.Path
import java.lang.reflect.Method
import org.jboss.resteasy.spi.ResteasyProviderFactory
import javax.ws.rs.core.UriInfo
import java.net.URI

object RestUtils {

  def buildPath(aClass: Class[_], pathName: String, params : AnyRef*) : URI = {
    val method = findMethod(aClass, pathName)

    val uriInfo= ResteasyProviderFactory.getContextData(classOf[UriInfo])

    uriInfo.getBaseUriBuilder
      .path(aClass)
      .path(method.get)
      .build(params)
  }

  def buildPath(aClass: Class[_], params : AnyRef*) : URI = {
    val uriInfo= ResteasyProviderFactory.getContextData(classOf[UriInfo])

    uriInfo.getBaseUriBuilder
      .path(aClass)
      .build(params)
  }

  private def findMethod(aClass: Class[_], pathName: String): Option[Method] = {
    aClass.getMethods.find(method => method.getAnnotation(classOf[Path]) match {
      case path: Path => path.value() == pathName
      case _ => false
    })
  }


}