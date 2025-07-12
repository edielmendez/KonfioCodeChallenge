package mx.com.edieltech.konfiocodechallenge.presentation.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mx.com.edieltech.konfiocodechallenge.domain.usecase.GetDogListUseCase
import mx.com.edieltech.konfiocodechallenge.presentation.core.architecture.MVIBaseViewModel
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeEffect
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.mvi.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogListUseCase: GetDogListUseCase
) : MVIBaseViewModel<HomeEvent, HomeUiState, HomeEffect>() {
    override fun createInitialState() = HomeUiState()

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetDogs -> getDogs()
        }
    }

    private fun getDogs(){
        getDogListUseCase()
            .catch {
                Log.v("HomeViewModel", "catch " + it.message.toString())
            }.onEach { dogList ->
                Log.v("HomeViewModel", "onEach $dogList")
                setState {
                    copy(dogList = dogList)
                }
            }.launchIn(viewModelScope)
    }

}