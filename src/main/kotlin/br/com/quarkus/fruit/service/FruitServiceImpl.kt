package br.com.quarkus.fruit.service

import br.com.quarkus.fruit.domain.Fruit
import br.com.quarkus.fruit.domain.observer.FruitObserver
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject


@ApplicationScoped
class FruitServiceImpl : FruitService {

    @Inject
    lateinit var fruitObserver: FruitObserver

    private var fruits: MutableList<Fruit> = mutableListOf()

    override fun retrieveAllFruits() = fruits.toList()

    override fun registerFruit(fruit: Fruit) {
        if (fruits.contains(fruit)) return
        fruits.add(fruit)
        fruitObserver.inserted(fruit)
    }

    override fun removeFruit(fruitName: String) {
        val fruit = fruits.find { it.name == fruitName }
        if (fruit != null) {
            fruits.remove(fruit)
            fruitObserver.removed(fruit)
        }
    }

    override fun findByName(name: String): Uni<Fruit> {
        val fruit = fruits.findLast { it.name == name }
        return Uni
            .createFrom()
            .item(fruit)
    }
}
