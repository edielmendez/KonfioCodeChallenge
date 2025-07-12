package mx.com.edieltech.konfiocodechallenge.domain.datasource

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

interface DogRemoteDataSource {
    fun getDogList(): Flow<List<DogModel>>
}