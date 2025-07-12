package mx.com.edieltech.konfiocodechallenge.domain.datasource

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

interface DogLocalDataSource {
    fun getDogList(): Flow<List<DogModel>>
    suspend fun saveDogList(dogList: List<DogModel>)
}