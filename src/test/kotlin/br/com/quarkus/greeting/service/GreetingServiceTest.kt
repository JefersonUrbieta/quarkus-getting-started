package br.com.quarkus.greeting.service

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject


@QuarkusTest
class GreetingServiceTest {

    @Inject
    lateinit var service: GreetingService

    @Test
    fun `#greeting test greeting service`() {
        Assertions.assertEquals("hello Quarkus", service.greeting("Quarkus"))
    }
}
