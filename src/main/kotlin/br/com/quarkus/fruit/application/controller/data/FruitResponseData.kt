package br.com.quarkus.fruit.application.controller.data

import br.com.quarkus.fruit.domain.Fruit

data class FruitResponseData(
    val name: String,
    val description: String
) {
    constructor(fruit: Fruit) : this(fruit.name, fruit.description)
}
