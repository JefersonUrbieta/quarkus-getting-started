package br.com.quarkus.fruit.domain.observer.events

import br.com.quarkus.fruit.domain.Fruit
import java.time.Instant

data class InsertedFruitEvent(
    val fruit: Fruit,
    val createdAt: Instant = Instant.now()
)
