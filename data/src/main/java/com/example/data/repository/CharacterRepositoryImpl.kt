package com.example.data.repository

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.data.mapper.mapCharacterResponseToDomainModel
import com.example.data.mapper.toCharacterList
import com.example.domain.model.CharacterDetailsResponse
import com.example.domain.model.CharacterModel
import com.example.domain.model.CharactersResponse
import com.example.domain.model.Episode
import com.example.domain.model.Location
import com.example.domain.repository.CharacterRepository
import com.example.ricknmorty.GetCharacterByIdQuery
import com.example.ricknmorty.GetCharactersQuery
import com.example.ricknmorty.fragment.CharacterDetail

class CharacterRepositoryImpl(private val apolloClient: ApolloClient) : CharacterRepository {
    override suspend fun getCharacters(page: Int): CharactersResponse {
        val response = apolloClient.query(GetCharactersQuery(page)).execute()
        val list = response.data?.characters?.results?.toCharacterList()
        return CharactersResponse(list)
    }

    override suspend fun getCharacterById(id: String): CharacterDetailsResponse {
        val response = apolloClient.query(GetCharacterByIdQuery(id)).execute()
        val character = response.data?.character?.characterDetail
        val characterModel = mapCharacterResponseToDomainModel(character)
        return CharacterDetailsResponse(characterModel)
    }


}