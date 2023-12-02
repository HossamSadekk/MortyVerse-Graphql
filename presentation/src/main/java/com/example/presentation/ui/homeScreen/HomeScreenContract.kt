package com.example.presentation.ui.homeScreen

import androidx.paging.PagingData
import com.example.domain.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

sealed class HomeScreenEvent {
    object LoadCharactersList : HomeScreenEvent()
}

data class HomeScreenViewState(
    val charactersPagedData: Flow<PagingData<Characters>> = emptyFlow(),
)

sealed class MainScreenState {
    object Init : MainScreenState()
    object Loading : MainScreenState()
    data class Error(val message: String) : MainScreenState()
    data class Content(
        val charactersPagedData: Flow<PagingData<Characters>> = emptyFlow(),
    ) : MainScreenState()
}