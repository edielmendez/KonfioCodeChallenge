package mx.com.edieltech.konfiocodechallenge.data.remote.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mx.com.edieltech.konfiocodechallenge.data.remote.mapper.toDomain
import mx.com.edieltech.konfiocodechallenge.data.remote.network.NetworkApiClient
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogRemoteDataSource
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import javax.inject.Inject

class DogRemoteDataSourceImpl @Inject constructor(
    private val client: NetworkApiClient
): DogRemoteDataSource {
    override fun getDogList(): Flow<List<DogModel>>  = flow {
        kotlin.runCatching {
            client.getDogs()
        }.onSuccess { response ->
            emit(
                response.map {
                    it.toDomain()
                }
            )
        }.onFailure {
            throw it
        }
    }
}