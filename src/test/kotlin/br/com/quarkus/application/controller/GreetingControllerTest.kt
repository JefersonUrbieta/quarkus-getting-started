package br.com.quarkus.application.controller

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import java.util.*

@QuarkusTest
class GreetingControllerTest {

    @Test
    fun `#greeting test greeting endpoint`() {
        val name = UUID.randomUUID().toString()
        given()
            .pathParam("name", name)
            .`when`().get("/hello/greeting/{name}")
            .then()
            .statusCode(200)
            .body(`is`("hello $name"))
    }

    @Test
    fun `#hello test hello endpoint`() {
        given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(`is`("hello quarkus!"))
    }
}
