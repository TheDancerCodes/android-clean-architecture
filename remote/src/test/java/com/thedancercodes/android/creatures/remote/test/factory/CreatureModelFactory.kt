package com.thedancercodes.android.creatures.remote.test.factory

import com.thedancercodes.android.creatures.remote.CreatureService
import com.thedancercodes.android.creatures.remote.model.CreatureModel
import com.thedancercodes.android.creatures.remote.test.factory.DataFactory.Factory.randomLong
import com.thedancercodes.android.creatures.remote.test.factory.DataFactory.Factory.randomUuid


/**
 * Factory class for CreatureModel related instances
 */
class CreatureModelFactory {

  companion object Factory {

    fun makeCreatureResponse(): CreatureService.CreatureResponse {
      val creatureResponse = CreatureService.CreatureResponse()
      creatureResponse.creatures = makeCreatureModelList(5)
      return creatureResponse
    }

    private fun makeCreatureModelList(count: Int): List<CreatureModel> {
      val creatureModels = mutableListOf<CreatureModel>()
      repeat(count) {
        creatureModels.add(makeCreatureModel())
      }
      return creatureModels
    }

    fun makeCreatureModel(): CreatureModel {
      return CreatureModel(randomLong(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid())
    }
  }
}