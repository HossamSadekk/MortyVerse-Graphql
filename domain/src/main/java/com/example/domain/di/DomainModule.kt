package com.example.domain.di

import com.example.domain.usecase.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharactersUseCase(get()) }

}