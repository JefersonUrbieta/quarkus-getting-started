package br.com.quarkus.greeting.service

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {

    fun greeting(name: String) = "hello $name"
}
