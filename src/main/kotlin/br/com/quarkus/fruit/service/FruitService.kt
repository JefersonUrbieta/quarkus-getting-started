package br.com.quarkus.fruit.service

import br.com.quarkus.fruit.domain.Fruit
import io.smallrye.mutiny.Uni

interface FruitService {
    fun retrieveAllFruits(): List<Fruit>

    fun registerFruit(fruit: Fruit)

    fun removeFruit(fruitName: String)

    fun findByName(name: String): Uni<Fruit>
}
