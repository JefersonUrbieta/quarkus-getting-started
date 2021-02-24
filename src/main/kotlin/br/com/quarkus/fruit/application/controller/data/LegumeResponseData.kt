package br.com.quarkus.fruit.application.controller.data

import br.com.quarkus.fruit.domain.Legume
import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
class LegumeResponseData(
    val name: String,
    val description: String
) {
    constructor(legume: Legume) : this(legume.name, legume.description)
}
