package com.example.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.data.repository.CharacterRepositoryImpl
import com.example.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single {
        ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }
    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}