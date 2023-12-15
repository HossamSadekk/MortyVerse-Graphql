package com.example.presentation.ui.homeScreen

import androidx.paging.PagingData
import com.example.domain.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

sealed class HomeScreenEvent {
    object LoadCharactersList : HomeScreenEvent()
    object RefreshScreen : HomeScreenEvent()
}

data class HomeScreenViewState(
    val charactersPagedData: Flow<PagingData<Characters>> = emptyFlow(),
)

