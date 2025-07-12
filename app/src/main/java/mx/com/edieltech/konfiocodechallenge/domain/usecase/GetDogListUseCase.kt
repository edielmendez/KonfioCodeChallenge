package mx.com.edieltech.konfiocodechallenge.domain.usecase

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.domain.repository.DogRepository
import javax.inject.Inject

class GetDogListUseCase @Inject constructor(
    private val repository: DogRepository
) {
    operator fun invoke(): Flow<List<DogModel>> = repository.getDogs()
}