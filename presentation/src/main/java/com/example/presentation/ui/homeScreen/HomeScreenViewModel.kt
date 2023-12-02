package com.example.presentation.ui.homeScreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.mvi.MviViewModel
import com.example.domain.usecase.GetCharactersUseCase
import com.exampleM.common.mvi.BaseViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.withContext
import timber.log.Timber


class HomeScreenViewModel(private val getCharactersUseCase: GetCharactersUseCase) :
    MviViewModel<BaseViewState<HomeScreenViewState>, HomeScreenEvent>() {

    private val _uiStates = MutableStateFlow<MainScreenState>(MainScreenState.Init)
    val uiStates = _uiStates.asStateFlow()
    override fun onTriggerEvent(eventType: HomeScreenEvent) {
        when (eventType) {
            is HomeScreenEvent.LoadCharactersList -> getCharacters()
        }
    }

    private fun getCharacters() = safeLaunch {
        //_uiStates.value = MainScreenState.Loading
        startLoading()
        withContext(Dispatchers.IO) {
            val pagedFlow = getCharactersUseCase().cachedIn(scope = viewModelScope).flowOn(Dispatchers.IO)
            setState(BaseViewState.Data(HomeScreenViewState(charactersPagedData = pagedFlow)))
            //_uiStates.value = MainScreenState.Content(pagedFlow)
        }
        //setState(BaseViewState.Data(HomeScreenViewState(charactersPagedData = pagedFlow)))
    }

    override fun handleError(exception: Throwable) {
        Timber.e("HomeScreenViewModel Exception -> $exception")
    }

}