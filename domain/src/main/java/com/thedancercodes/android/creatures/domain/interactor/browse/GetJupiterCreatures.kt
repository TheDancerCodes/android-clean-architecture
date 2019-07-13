package com.thedancercodes.android.creatures.domain.interactor.browse

import com.thedancercodes.android.creatures.domain.executor.PostExecutionThread
import com.thedancercodes.android.creatures.domain.executor.ThreadExecutor
import com.thedancercodes.android.creatures.domain.interactor.FlowableUseCase
import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.domain.repository.CreatureRepository
import io.reactivex.Flowable
import javax.inject.Inject

open class GetJupiterCreatures @Inject constructor(
        private val creatureRepository: CreatureRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread):
        FlowableUseCase<List<Creature>, Void?>(threadExecutor, postExecutionThread){
    /**
     * Builds a [Single] which will be used when the current [FlowableUseCase] is executed.
     */
    public override fun buildUseCaseObservable(params: Void?): Flowable<List<Creature>> {
        return creatureRepository.getJupiterCreatures()
    }
}