package mx.com.edieltech.konfiocodechallenge.data.local.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mx.com.edieltech.konfiocodechallenge.data.local.main.dao.DogDao
import mx.com.edieltech.konfiocodechallenge.data.local.mapper.toDomain
import mx.com.edieltech.konfiocodechallenge.domain.datasource.DogLocalDataSource
import mx.com.edieltech.konfiocodechallenge.domain.mapper.toEntity
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import javax.inject.Inject

class DogLocalDataSourceImpl @Inject constructor(
    private val dao: DogDao
): DogLocalDataSource {
    override fun getDogList(): Flow<List<DogModel>> {
        return dao.getAll().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun saveDogList(dogList: List<DogModel>) {
        dao.insertAll(
            dogList = dogList.map { it.toEntity() }
        )
    }
}