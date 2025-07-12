package mx.com.edieltech.konfiocodechallenge.data.local.mapper

import mx.com.edieltech.konfiocodechallenge.data.local.main.entities.DogEntity
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

fun DogEntity.toDomain() = DogModel(
    name = name,
    description = description,
    age = age,
    image = image
)