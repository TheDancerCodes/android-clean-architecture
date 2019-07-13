package com.thedancercodes.android.creatures.ui.injection

import android.app.Application
import com.thedancercodes.android.creatures.ui.CreaturesApplication
import com.thedancercodes.android.creatures.ui.injection.module.ActivityBindingModule
import com.thedancercodes.android.creatures.ui.injection.module.ApplicationModule
import com.thedancercodes.android.creatures.ui.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
    AndroidSupportInjectionModule::class))
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder
    fun build(): ApplicationComponent
  }

  fun inject(app: CreaturesApplication)

}