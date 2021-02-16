package br.com.quarkus.application.controller

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeGreetingControllerIT : GreetingControllerTest()
