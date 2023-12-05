package com.example.presentation.ui.CharacterDetails

import androidx.lifecycle.SavedStateHandle
import com.example.common.mvi.MviViewModel
import com.example.domain.usecase.GetCharacterById
import com.exampleM.common.mvi.BaseViewState
import timber.log.Timber

class CharacterDetailsViewModel(
    private val getCharacterById: GetCharacterById,
    savedStateHandle: SavedStateHandle
) :
    MviViewModel<BaseViewState<CharacterDetailsState>, CharacterDetailsEvent>() {

    init {
        val id = savedStateHandle.get<String>("characterId")
        if (id != null) {
            getCharacterDetails(id)
        }
    }
    override fun onTriggerEvent(eventType: CharacterDetailsEvent) {
        when (eventType) {
            is CharacterDetailsEvent.LoadCharacterDetails -> {
                getCharacterDetails(eventType.id)
            }
            else -> {}
        }
    }

    fun getCharacterDetails(id: String) = safeLaunch {
        startLoading()
        execute(getCharacterById(id)) { characterDetails ->
            setState(BaseViewState.Data(CharacterDetailsState(characterDetails = characterDetails)))
        }
    }

    override fun handleError(exception: Throwable) {
        Timber.e("HomeScreenViewModel Exception -> $exception")
        setState(BaseViewState.Error(exception))
    }
}