package br.com.quarkus.fruit.domain.observer

import br.com.quarkus.fruit.domain.Fruit
import br.com.quarkus.fruit.domain.observer.events.InsertedFruitEvent
import br.com.quarkus.fruit.domain.observer.events.RemovedFruitEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Event
import javax.inject.Inject

@ApplicationScoped
class FruitObserver {

    @Inject
    lateinit var insertedEvent: Event<InsertedFruitEvent>

    @Inject
    lateinit var removedEvent: Event<RemovedFruitEvent>

    fun inserted(fruit: Fruit) {
        insertedEvent.fire(InsertedFruitEvent(fruit))
    }

    fun removed(fruit: Fruit) {
        removedEvent.fire(RemovedFruitEvent(fruit))
    }
}
