package br.com.quarkus.fruit.application.controller

import br.com.quarkus.fruit.application.controller.data.LegumeResponseData
import br.com.quarkus.fruit.service.LegumeService
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/legumes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LegumeController {

    @Inject
    lateinit var legumeService: LegumeService

    @GET
    fun list(): Response {
        val legumes = legumeService
            .retrieveAllLegumes()
            .map { LegumeResponseData(it) }
            .toList()

        return Response
            .ok(legumes)
            .build()
    }
}
