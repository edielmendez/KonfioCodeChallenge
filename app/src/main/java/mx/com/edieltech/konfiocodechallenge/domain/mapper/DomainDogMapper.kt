package mx.com.edieltech.konfiocodechallenge.domain.mapper

import mx.com.edieltech.konfiocodechallenge.data.local.main.entities.DogEntity
import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel

fun DogModel.toEntity() = DogEntity(
    name = name,
    description = description,
    age = age,
    image = image
)