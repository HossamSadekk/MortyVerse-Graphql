package com.example.presentation.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.usecase.GetCharactersUseCase
import com.example.presentation.ui.CharacterDetails.CharacterDetailsViewModel
import com.example.presentation.ui.CharacterSearch.SearchViewModel
import com.example.presentation.ui.homeScreen.HomeScreenViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        HomeScreenViewModel(get())
    }
    viewModel{
        CharacterDetailsViewModel(get(),get())
    }
    viewModel{
        SearchViewModel(get())
    }
}