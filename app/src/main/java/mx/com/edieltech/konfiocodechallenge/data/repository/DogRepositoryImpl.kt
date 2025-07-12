package mx.com.edieltech.konfiocodechallenge.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogLocalDataSource
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogRemoteDataSource
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.domain.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val remoteDataSource: DogRemoteDataSource,
    private val localDataSource: DogLocalDataSource
) : DogRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getDogs(): Flow<List<DogModel>> = localDataSource.getDogList()
        .flatMapLatest { localDogs ->
            if (localDogs.isEmpty()) {
                remoteDataSource.getDogList().onEach { remoteDogs ->
                    localDataSource.saveDogList(remoteDogs)
                }
            } else {
                flowOf(localDogs)
            }
        }
}