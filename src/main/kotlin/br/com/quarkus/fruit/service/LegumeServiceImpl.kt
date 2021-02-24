package br.com.quarkus.fruit.service

import br.com.quarkus.fruit.domain.Legume
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class LegumeServiceImpl : LegumeService {

    private var legumes: MutableList<Legume> = mutableListOf(
        Legume("Carrot", "Root vegetable, usually orange"),
        Legume("Zucchini", "Summer squash")
    )

    override fun retrieveAllLegumes() = legumes.toList()
}
