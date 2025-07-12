package mx.com.edieltech.konfiocodechallenge.data.remote.mapper

import mx.com.edieltech.konfiocodechallenge.data.remote.response.GetDogListResponse
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

fun GetDogListResponse.toDomain() = DogModel(
    name = dogName.orEmpty(),
    description = description.orEmpty(),
    age = age ?: 0,
    image = image.orEmpty()
)