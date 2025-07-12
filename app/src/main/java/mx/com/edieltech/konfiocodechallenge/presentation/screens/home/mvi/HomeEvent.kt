package mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi

import mx.com.edieltech.konfiocodechallenge.presentation.core.architecture.MVIUiEvent

sealed interface HomeEvent: MVIUiEvent {
    data object GetDogs: HomeEvent
}