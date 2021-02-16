package br.com.quarkus.commons.lifesycle

import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import org.jboss.logging.Logger
import java.time.Duration
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

@ApplicationScoped
class AppLifecycleBean {

    fun onStart(@Observes ev: StartupEvent) {
        logger.info("The application is starting...");
    }

    fun onStop(@Observes ev: ShutdownEvent) {
        logger.info("The application is stopping...");
    }

    companion object {
        val logger: Logger = Logger.getLogger(AppLifecycleBean::class.java)
    }
}
