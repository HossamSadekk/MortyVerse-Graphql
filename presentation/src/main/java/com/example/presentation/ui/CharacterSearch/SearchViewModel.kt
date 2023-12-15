package com.example.presentation.ui.CharacterSearch

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.mvi.MviViewModel
import com.example.domain.usecase.GetCharactersUseCase
import com.exampleM.common.mvi.BaseViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel(private val getCharactersUseCase: GetCharactersUseCase) :
    MviViewModel<BaseViewState<SearchScreenViewState>, SearchScreenEvent>() {

    private val _searchString = MutableStateFlow("")
    val searchString = _searchString.asStateFlow()

    private var searchJob: Job? = null

    override fun onTriggerEvent(eventType: SearchScreenEvent) {
        when (eventType) {
            is SearchScreenEvent.LoadCharactersList -> {
                searchCharacterByName(eventType.searchString)
            }

            is SearchScreenEvent.RefreshScreen -> {
                refreshScreen()
            }
        }
    }

    private fun searchCharacterByName(searchString: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (searchString.length > 3) delay(500)
            startLoading()
            val pagedFlow =
                getCharactersUseCase
                    .invoke(searchString)
                    .cachedIn(scope = viewModelScope)
                    .flowOn(Dispatchers.IO)
            setState(BaseViewState.Data(SearchScreenViewState(charactersPagedData = pagedFlow)))
        }
    }

    fun searchCharacter(name: String) {
        if (name == "") {
            setState(BaseViewState.Empty)
        }
        _searchString.value = name
    }

    private fun refreshScreen() {
        searchCharacterByName(searchString.value)
    }

    override fun handleError(exception: Throwable) {
        Timber.e("SearchViewModel Exception -> $exception")
        setState(BaseViewState.Error(exception))
    }
}