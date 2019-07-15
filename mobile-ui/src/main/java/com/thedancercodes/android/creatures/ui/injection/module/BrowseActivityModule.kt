package com.thedancercodes.android.creatures.ui.injection.module

import com.thedancercodes.android.creatures.domain.interactor.browse.GetCreatures
import com.thedancercodes.android.creatures.domain.interactor.browse.GetJupiterCreatures
import com.thedancercodes.android.creatures.presentation.browse.BrowseCreaturesViewModelFactory
import com.thedancercodes.android.creatures.presentation.mapper.CreatureMapper
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

  @Provides
  fun provideBrowseCreaturesViewModelFactory(getCreatures: GetCreatures,
                                             getJupiterCreatures: GetJupiterCreatures,
                                             creatureMapper: CreatureMapper):
      BrowseCreaturesViewModelFactory {
    return BrowseCreaturesViewModelFactory(getCreatures, getJupiterCreatures, creatureMapper)
  }

}