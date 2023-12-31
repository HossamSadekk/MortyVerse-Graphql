package com.example.domain.repository

import com.example.domain.model.CharacterDetailsResponse
import com.example.domain.model.CharactersResponse

interface CharacterRepository {
    suspend fun getCharacters(page: Int, name: String? = null): CharactersResponse
    suspend fun getCharacterById(id: String): CharacterDetailsResponse

}