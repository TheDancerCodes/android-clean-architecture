package com.thedancercodes.android.creatures.data

import com.thedancercodes.android.creatures.data.mapper.CreatureMapper
import com.thedancercodes.android.creatures.data.model.CreatureEntity
import com.thedancercodes.android.creatures.data.source.CreatureDataStoreFactory
import com.thedancercodes.android.creatures.domain.model.Creature
import com.thedancercodes.android.creatures.domain.repository.CreatureRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * Provides an implementation of the [CreatureRepository] interface for communicating to and from
 * data sources
 */
class CreatureDataRepository @Inject constructor(private val factory: CreatureDataStoreFactory,
                                                 private val creatureMapper: CreatureMapper) : CreatureRepository {

  override fun clearCreatures(): Completable {
    return factory.retrieveCacheDataStore().clearCreatures()
  }

  override fun saveCreatures(creatures: List<Creature>): Completable {
    val creatureEntities = mutableListOf<CreatureEntity>()
    creatures.map { creatureEntities.add(creatureMapper.mapToEntity(it)) }
    return factory.retrieveCacheDataStore().saveCreatures(creatureEntities)
  }

  /*
     We call getCreatures() from the domain layer &
     This is the implementation of the method in the data layer
  */
  override fun getCreatures(): Flowable<List<Creature>> {
    return factory.retrieveCacheDataStore().isCached()
        .flatMapPublisher {
          factory.retrieveDataStore(it).getCreatures()
        }
        .flatMap {
          Flowable.just(it.map { creatureMapper.mapFromEntity(it) })
        }
        .flatMap {
          saveCreatures(it).toSingle { it }.toFlowable()
        }
  }

  // TODO: getJupiterCreatures
}