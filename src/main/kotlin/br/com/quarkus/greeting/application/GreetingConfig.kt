package br.com.quarkus.greeting.application

import org.eclipse.microprofile.config.inject.ConfigProperty
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingConfig(
    @ConfigProperty(name = "greeting.message")
    val message: String,

    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")
    val suffix: String,

    @ConfigProperty(name = "greeting.name")
    val name: Optional<String>
)
