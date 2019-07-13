package com.thedancercodes.android.creatures.ui.test.utils

import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.presentation.model.CreatureView
import com.thedancercodes.android.creatures.ui.test.utils.DataFactory.randomLong
import com.thedancercodes.android.creatures.ui.test.utils.DataFactory.randomUuid


/**
 * Factory class for Creature related instances
 */
object CreatureFactory {

  fun makeCreatureView(): CreatureView {
    return CreatureView(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
  }

  fun makeCreatureList(count: Int): List<Creature> {
    val creatures = mutableListOf<Creature>()
    repeat(count) {
      creatures.add(CreatureFactory.makeCreatureModel())
    }
    return creatures
  }

  fun makeCreatureModel(): Creature {
    return Creature(randomLong(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
  }
}