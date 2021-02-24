package br.com.quarkus.fruit.application.controller.data

import br.com.quarkus.fruit.domain.Fruit

class FruitRegisterData(
    val name: String,
    val description: String
) {
    fun toDomain() = Fruit(name, description)
}
