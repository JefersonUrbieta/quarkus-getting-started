package br.com.quarkus.fruit.application.controller

import br.com.quarkus.fruit.application.controller.data.FruitRegisterData
import br.com.quarkus.fruit.application.controller.data.FruitResponseData
import br.com.quarkus.fruit.service.FruitService
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.Response


@Path("/fruits")
class FruitController {

    @Inject
    lateinit var fruitService: FruitService

    @GET
    fun list(): List<FruitResponseData> {
        return fruitService
            .retrieveAllFruits()
            .map { FruitResponseData(it) }
            .toList()
    }

    @POST
    fun register(fruit: FruitRegisterData): Response {
        fruitService.registerFruit(fruit.toDomain())

        return Response
            .ok()
            .build()
    }

    @DELETE
    @Path("/{name}")
    fun delete(@PathParam("name") name: String): Response {
        fruitService.removeFruit(name)

        return Response
            .ok()
            .build()
    }

    @GET
    @Path("/{name}")
    fun getOne(@PathParam("name") name: String): Uni<FruitResponseData> {
        return fruitService.findByName(name).map { FruitResponseData(it) }
    }
}
