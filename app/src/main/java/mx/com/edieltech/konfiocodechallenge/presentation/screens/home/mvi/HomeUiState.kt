package mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi

import mx.com.edieltech.konfiocodechallenge.domain.models.DogModel
import mx.com.edieltech.konfiocodechallenge.presentation.core.architecture.MVIUiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val dogList: List<DogModel> = emptyList(),
): MVIUiState
