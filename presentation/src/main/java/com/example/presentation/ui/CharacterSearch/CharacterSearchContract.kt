package com.example.presentation.ui.CharacterSearch

import androidx.paging.PagingData
import com.example.domain.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

sealed class SearchScreenEvent {
    data class LoadCharactersList(val searchString: String) : SearchScreenEvent()
    object RefreshScreen : SearchScreenEvent()
}

data class SearchScreenViewState(
    val charactersPagedData: Flow<PagingData<Characters>> = emptyFlow(),
)