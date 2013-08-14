package com.phanative.module.rest.provider.jersey

import com.sun.jersey.multipart.impl.MultiPartWriter
import javax.ws.rs.Produces
import javax.ws.rs.ext.{Providers, Provider}
import javax.ws.rs.core.Context

@Provider
@Produces(Array("multipart/*"))
class ScalaMultiPartWriter(@Context providers: Providers) extends MultiPartWriter(providers){

}