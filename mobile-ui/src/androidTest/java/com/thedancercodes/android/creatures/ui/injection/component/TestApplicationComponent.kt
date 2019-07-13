package com.thedancercodes.android.creatures.ui.injection.component

import android.app.Application
import com.thedancercodes.android.creatures.domain.executor.PostExecutionThread
import com.thedancercodes.android.creatures.domain.repository.CreatureRepository
import com.thedancercodes.android.creatures.ui.injection.ApplicationComponent
import com.thedancercodes.android.creatures.ui.injection.module.ActivityBindingModule
import com.thedancercodes.android.creatures.ui.injection.module.TestApplicationModule
import com.thedancercodes.android.creatures.ui.injection.scopes.PerApplication
import com.thedancercodes.android.creatures.ui.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = arrayOf(TestApplicationModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

  fun creatureRepository(): CreatureRepository

  fun postExecutionThread(): PostExecutionThread

  fun inject(application: TestApplication)

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): TestApplicationComponent.Builder

    fun build(): TestApplicationComponent
  }
}