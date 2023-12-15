package com.example.presentation.ui.homeScreen

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.mvi.MviViewModel
import com.example.domain.usecase.GetCharactersUseCase
import com.exampleM.common.mvi.BaseViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber


class HomeScreenViewModel(private val getCharactersUseCase: GetCharactersUseCase) :
    MviViewModel<BaseViewState<HomeScreenViewState>, HomeScreenEvent>() {
    override fun onTriggerEvent(eventType: HomeScreenEvent) {
        when (eventType) {
            is HomeScreenEvent.LoadCharactersList -> getCharacters()
            is HomeScreenEvent.RefreshScreen -> refreshScreen()
        }
    }

    fun refreshScreen() {
        getCharacters()
    }

    private fun getCharacters() = safeLaunch {
        startLoading()
        val pagedFlow =
            getCharactersUseCase().cachedIn(scope = viewModelScope).flowOn(Dispatchers.IO)
        setState(BaseViewState.Data(HomeScreenViewState(charactersPagedData = pagedFlow)))
    }

    override fun handleError(exception: Throwable) {
        Timber.e("HomeScreenViewModel Exception -> $exception")
        setState(BaseViewState.Error(exception))
    }

}