package br.com.quarkus.fruit.domain.observer

import br.com.quarkus.fruit.domain.observer.events.InsertedFruitEvent
import br.com.quarkus.fruit.domain.observer.events.RemovedFruitEvent
import org.jboss.logging.Logger
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes


@ApplicationScoped
class FruitLogger {

    @PostConstruct
    fun init() {
        logger.info("fruit logger was created")
    }

    @PreDestroy
    fun destroy() {
        logger.info("fruit logger was destroyed")
    }

    fun onFruitInserted(@Observes insertedFruitEvent: InsertedFruitEvent) {
        logger.info("inserted fruit name=${insertedFruitEvent.fruit.name}")
    }

    fun onFruitRemoved(@Observes removedFruitEvent: RemovedFruitEvent) {
        logger.info("removed fruit name=${removedFruitEvent.fruit.name}")
    }

    companion object {
        val logger: Logger = Logger.getLogger(FruitLogger::class.java)
    }
}
