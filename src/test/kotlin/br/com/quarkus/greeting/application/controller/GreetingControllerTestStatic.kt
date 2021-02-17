package br.com.quarkus.greeting.application.controller

import br.com.quarkus.greeting.application.controller.GreetingController
import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.common.http.TestHTTPResource
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.nio.charset.StandardCharsets


@QuarkusTest
class GreetingControllerTestStatic {

    @TestHTTPEndpoint(GreetingController::class)
    @TestHTTPResource
    lateinit var url: URL

    @Test
    @Throws(Exception::class)
    fun testIndexHtml() {
        url.openStream().use {
            val contents = readStream(it)
            Assertions.assertEquals("hello tester!", contents)
        }
    }

    @Throws(IOException::class)
    private fun readStream(inputStream: InputStream): String {
        val data = ByteArray(1024)
        var r: Int
        val out = ByteArrayOutputStream()
        while (inputStream.read(data).also { r = it } > 0) {
            out.write(data, 0, r)
        }
        return String(out.toByteArray(), StandardCharsets.UTF_8)
    }
}
