package br.com.quarkus.greeting.application.controller

import br.com.quarkus.greeting.application.controller.GreetingController
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import java.util.*

@QuarkusTest
@TestHTTPEndpoint(GreetingController::class)
class GreetingControllerTest {

    @Test
    fun `#greeting test greeting endpoint`() {
        val name = UUID.randomUUID().toString()
        given()
            .pathParam("name", name)
            .`when`().get("/greeting/{name}")
            .then()
            .statusCode(200)
            .body(`is`("hello $name"))
    }

    @Test
    fun `#hello test hello endpoint`() {
        given()
            .`when`().get()
            .then()
            .statusCode(200)
            .body(`is`("hello tester!"))
    }
}
