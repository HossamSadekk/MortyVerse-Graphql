package com.example.data.repository

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.data.mapper.toCharacterList
import com.example.domain.model.CharactersResponse
import com.example.domain.repository.CharacterRepository
import com.example.ricknmorty.GetCharactersQuery

class CharacterRepositoryImpl(private val apolloClient: ApolloClient) : CharacterRepository {
    override suspend fun getCharacters(page: Int): CharactersResponse {
        val response = apolloClient.query(GetCharactersQuery(1)).execute()
        val list = response.data?.characters?.results?.toCharacterList()
        return CharactersResponse(list)
    }

}