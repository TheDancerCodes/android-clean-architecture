package com.thedancercodes.android.creatures.data.test.factory

import com.thedancercodes.android.creatures.data.model.CreatureEntity
import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.data.test.factory.DataFactory.Factory.randomLong
import com.thedancercodes.android.creatures.data.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for CreatureEntity related instances
 */
class CreatureEntityFactory {

  companion object Factory {

    fun makeCreatureEntity(): CreatureEntity {
      return CreatureEntity(randomLong(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
    }

    fun makeCreature(): Creature {
      return Creature(randomLong(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
    }

    fun makeCreatureEntityList(count: Int): List<CreatureEntity> {
      val creatureEntities = mutableListOf<CreatureEntity>()
      repeat(count) {
        creatureEntities.add(makeCreatureEntity())
      }
      return creatureEntities
    }

    fun makeCreatureList(count: Int): List<Creature> {
      val creatures = mutableListOf<Creature>()
      repeat(count) {
        creatures.add(makeCreature())
      }
      return creatures
    }

    // Stub out data coming back from SQLite DB
    private fun makeJupiterCreatureEntity(): CreatureEntity =
        CreatureEntity(randomLong(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            "Jupiter")

    private fun makeJupiterCreature(): Creature =
        Creature(randomLong(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            "Jupiter")

    private fun makeMarsCreatureEntity(): CreatureEntity =
        CreatureEntity(randomLong(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            "Mars")

    private fun makeMarsCreature(): Creature =
        Creature(randomLong(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            "Mars")

    fun makeJupiterCreatureEntityList(count: Int): List<CreatureEntity> {
      val creatureEntities = mutableListOf<CreatureEntity>()
      repeat(count / 2) {
        creatureEntities.add(makeMarsCreatureEntity())
      }

      repeat(count / 2) {
        creatureEntities.add(makeJupiterCreatureEntity())
      }
      return creatureEntities
    }

    fun makeJupiterCreatureList(count: Int): List<Creature> {
      val creatures = mutableListOf<Creature>()
      repeat(count / 2) {
        creatures.add(makeMarsCreature())
      }
      repeat(count / 2) {
        creatures.add(makeJupiterCreature())
      }
      return creatures
    }
  }
}