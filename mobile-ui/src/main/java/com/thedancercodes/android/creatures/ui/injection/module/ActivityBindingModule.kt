package com.thedancercodes.android.creatures.ui.injection.module

import com.thedancercodes.android.creatures.ui.browse.MainActivity
import com.thedancercodes.android.creatures.ui.injection.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

  @PerActivity
  @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
  abstract fun bindMainActivity(): MainActivity

}