package com.thedancercodes.android.creatures.domain.interactor.browse

import com.thedancercodes.android.creatures.domain.executor.PostExecutionThread
import com.thedancercodes.android.creatures.domain.executor.ThreadExecutor
import com.thedancercodes.android.creatures.domain.interactor.FlowableUseCase
import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.domain.repository.CreatureRepository
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * Use case used for retrieving a [List] of [Creature] instances from the [CreatureRepository]
 */
open class GetCreatures @Inject constructor(private val creatureRepository: CreatureRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
    FlowableUseCase<List<Creature>, Void?>(threadExecutor, postExecutionThread) {

  public override fun buildUseCaseObservable(params: Void?): Flowable<List<Creature>> {
    return creatureRepository.getCreatures()
  }
}