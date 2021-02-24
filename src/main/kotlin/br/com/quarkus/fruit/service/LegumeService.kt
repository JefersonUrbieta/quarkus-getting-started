package br.com.quarkus.fruit.service

import br.com.quarkus.fruit.domain.Fruit
import br.com.quarkus.fruit.domain.Legume

interface LegumeService {
    fun retrieveAllLegumes(): List<Legume>
}
