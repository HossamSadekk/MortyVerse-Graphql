package com.example.presentation.ui.CharacterDetails

import androidx.paging.PagingData
import com.example.domain.model.CharacterModel
import com.example.domain.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

sealed class CharacterDetailsEvent {
    data class LoadCharacterDetails (val id:String): CharacterDetailsEvent()
    object RefreshScreen : CharacterDetailsEvent()
}
data class CharacterDetailsState(
    val characterDetails: CharacterModel,
)