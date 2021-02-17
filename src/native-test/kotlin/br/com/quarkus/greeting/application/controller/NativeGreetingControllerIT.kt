package br.com.quarkus.greeting.application.controller

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeGreetingControllerIT : GreetingControllerTest()
