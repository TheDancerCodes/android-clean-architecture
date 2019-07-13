package com.thedancercodes.android.creatures.ui.test.factory

import com.thedancercodes.android.creatures.presentation.model.CreatureView
import com.thedancercodes.android.creatures.ui.test.factory.DataFactory.randomUuid


/**
 * Factory class for Creature related instances
 */
object CreatureFactory {
  fun makeCreatureView(): CreatureView {
    return CreatureView(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
  }
}