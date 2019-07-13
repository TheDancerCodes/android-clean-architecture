package com.thedancercodes.android.creatures.ui.mapper

import com.thedancercodes.android.creatures.presentation.model.CreatureView
import com.thedancercodes.android.creatures.ui.model.CreatureViewModel
import javax.inject.Inject


/**
 * Map a [CreatureView] to and from a [CreatureViewModel] instance when data is moving between
 * this layer and the Presentation layer
 */
open class CreatureMapper @Inject constructor(): Mapper<CreatureViewModel, CreatureView> {
  override fun mapToViewModel(type: CreatureView) =
    CreatureViewModel(type.firstName, type.lastName, type.nickname, type.image, type.planet)
}