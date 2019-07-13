package com.thedancercodes.android.creatures.presentation.browse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.thedancercodes.android.creatures.domain.interactor.browse.GetCreatures
import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.presentation.data.Resource
import com.thedancercodes.android.creatures.presentation.data.ResourceState
import com.thedancercodes.android.creatures.presentation.mapper.CreatureMapper
import com.thedancercodes.android.creatures.presentation.model.CreatureView
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

// TODO: Add GetJupiterCreatures to constructor
open class BrowseCreaturesViewModel @Inject internal constructor(

    // ViewModel Properties
    private val getCreatures: GetCreatures,
    private val creatureMapper: CreatureMapper) : ViewModel() {

  private val creaturesLiveData: MutableLiveData<Resource<List<CreatureView>>> = MutableLiveData()
  // TODO: Add jupiterLiveData

  init {
    fetchCreatures()
  }

  override fun onCleared() {
    getCreatures.dispose()
    super.onCleared()
  }

  // Returns a LiveData object (creaturesLiveData)
  fun getCreatures(): LiveData<Resource<List<CreatureView>>> {
    return creaturesLiveData
  }

  /* Called when a ViewModel gets initialised.

     Inside of it, its posting a LOADING state into the LiveData.
     This is the resource for when the screen first comes up.

     Finally executes a method on the getCreatures property of the ViewModel. */
  fun fetchCreatures() {
    creaturesLiveData.postValue(Resource(ResourceState.LOADING, null, null))
    return getCreatures.execute(CreatureSubscriber())
  }

  // TODO: Add getJupiter and fetchJupiter

  inner class CreatureSubscriber: DisposableSubscriber<List<Creature>>() {

    override fun onComplete() { }

    override fun onNext(t: List<Creature>) {
      creaturesLiveData.postValue(Resource(ResourceState.SUCCESS,
          t.map { creatureMapper.mapToView(it) }, null))
    }

    override fun onError(exception: Throwable) {
      creaturesLiveData.postValue(Resource(ResourceState.ERROR, null, exception.message))
    }
  }

  // TODO: Add JupiterSubscriber
}