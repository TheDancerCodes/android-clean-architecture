package com.thedancercodes.android.creatures.ui.test

import android.app.Activity
import android.app.Application
import android.support.test.InstrumentationRegistry
import com.thedancercodes.android.creatures.ui.injection.component.DaggerTestApplicationComponent
import com.thedancercodes.android.creatures.ui.injection.component.TestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class TestApplication: Application(), HasActivityInjector {

  @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

  private lateinit var appComponent: TestApplicationComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerTestApplicationComponent.builder().application(this).build()
    appComponent.inject(this)
  }

  companion object {

    fun appComponent(): TestApplicationComponent {
      return (InstrumentationRegistry.getTargetContext().applicationContext as TestApplication).
          appComponent
    }

  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return injector
  }
}