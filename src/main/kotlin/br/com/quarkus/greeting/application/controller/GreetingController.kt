package br.com.quarkus.greeting.application.controller

import br.com.quarkus.greeting.application.GreetingConfig
import br.com.quarkus.greeting.service.GreetingService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingController {

    @Inject
    lateinit var greetingService: GreetingService

    @Inject
    lateinit var greetingConfig: GreetingConfig

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    fun greeting(@PathParam("name") name: String): String {
        return greetingService.greeting(name)
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "${greetingConfig.message} ${greetingConfig.name.orElse("world") }${greetingConfig.suffix}"
}
