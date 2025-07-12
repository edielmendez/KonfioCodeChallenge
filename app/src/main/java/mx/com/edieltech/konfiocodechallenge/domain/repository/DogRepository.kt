package mx.com.edieltech.konfiocodechallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

interface DogRepository {
    fun getDogs(): Flow<List<DogModel>>
}