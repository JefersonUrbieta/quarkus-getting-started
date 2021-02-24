package br.com.quarkus.fruit.service

import br.com.quarkus.fruit.domain.Fruit
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.reactivestreams.Publisher
import java.time.Duration
import javax.enterprise.context.ApplicationScoped
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier


@ApplicationScoped
class FruitServiceImpl : FruitService {

    private var fruits: MutableList<Fruit> = mutableListOf()

    override fun retrieveAllFruits() = fruits.toList()

    override fun registerFruit(fruit: Fruit) {
        if (fruits.contains(fruit)) return
        fruits.add(fruit)
    }

    override fun removeFruit(fruitName: String) {
        fruits.removeIf { it.name == fruitName }
    }

    override fun findByName(name: String): Uni<Fruit> {
        val fruit = fruits.findLast { it.name == name }
        return Uni
            .createFrom()
            .item(fruit)
    }
}
