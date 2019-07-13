package com.thedancercodes.android.creatures.domain.test.factory

import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.domain.test.factory.DataFactory.Factory.randomLong
import com.thedancercodes.android.creatures.domain.test.factory.DataFactory.Factory.randomUuid


/**
 * Factory class for Creature related instances
 */
class CreatureFactory {

  companion object Factory {
    fun makeCreatureList(count: Int): List<Creature> {
      val creatures = mutableListOf<Creature>()
      repeat(count) {
        creatures.add(makeCreature())
      }
      return creatures
    }

    private fun makeCreature() = Creature(randomLong(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())

    // Calls into the makeJupiterCreature method and creates a list of creatures
    fun makeJupiterCreatureList(count: Int): List<Creature> {
      val creatures = mutableListOf<Creature>()
      repeat(count) {
        creatures.add(makeJupiterCreature())
      }
      return creatures
    }

    // Creates a model object Creature
    private fun makeJupiterCreature() = Creature(randomLong(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        randomUuid(),
        "Jupiter")
  }
}