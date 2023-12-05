package com.example.domain.usecase

import com.example.common.use_case.DataState
import com.example.common.use_case.UseCase
import com.example.common.use_case.apiCall
import com.example.domain.model.CharacterModel
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.FlowCollector

class GetCharacterById(private val repository: CharacterRepository): UseCase<CharacterModel>() {
    override suspend fun FlowCollector<DataState<CharacterModel>>.execute(parameter: String?) {
        val characterModel = repository.getCharacterById(id = parameter?: "0").character
        val serviceCall = apiCall { characterModel!! }
        emit(serviceCall)
    }
}