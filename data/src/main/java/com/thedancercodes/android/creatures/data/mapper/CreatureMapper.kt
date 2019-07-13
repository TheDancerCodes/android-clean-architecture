package com.thedancercodes.android.creatures.data.mapper

import com.thedancercodes.android.creatures.data.model.CreatureEntity
import com.thedancercodes.android.creatures.domain.model.Creature
import javax.inject.Inject


open class CreatureMapper @Inject constructor(): Mapper<CreatureEntity, Creature> {

  override fun mapFromEntity(type: CreatureEntity) =
      Creature(type.id, type.firstName, type.lastName, type.nickname, type.image, type.planet)

  override fun mapToEntity(type: Creature) =
      CreatureEntity(type.id, type.firstName, type.lastName, type.nickname, type.image, type.planet)
}