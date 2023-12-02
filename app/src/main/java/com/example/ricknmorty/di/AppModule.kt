package com.example.ricknmorty.di

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = listOf(presentationModule, domainModule , dataModule)