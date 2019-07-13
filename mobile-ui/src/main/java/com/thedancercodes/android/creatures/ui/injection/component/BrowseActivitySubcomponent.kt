package com.thedancercodes.android.creatures.ui.injection.component

import com.thedancercodes.android.creatures.ui.browse.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<MainActivity> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<MainActivity>()

}