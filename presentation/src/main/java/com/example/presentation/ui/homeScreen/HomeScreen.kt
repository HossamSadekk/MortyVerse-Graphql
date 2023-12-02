package com.example.presentation.characters.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.presentation.R
import com.example.presentation.ui.components.HomeScreenContent
import com.example.presentation.ui.components.ProgressIndicator
import com.example.presentation.ui.components.cast
import com.example.presentation.ui.homeScreen.HomeScreenEvent
import com.example.presentation.ui.homeScreen.HomeScreenViewModel
import com.example.presentation.ui.homeScreen.HomeScreenViewState
import com.example.rickandmorty.ui.AppBar
import com.exampleM.common.mvi.BaseViewState
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUi(vm: HomeScreenViewModel = koinViewModel()) {
    KoinAndroidContext() {

        LaunchedEffect(key1 = vm, block = {
            vm.onTriggerEvent(HomeScreenEvent.LoadCharactersList)
        })
        val uiState by vm.uiState.collectAsState()
        Log.d("hossam", uiState.toString())
        Scaffold(
            topBar = {
                AppBar(
                    icon1 = R.drawable.round_search_24,
                    title = "Rick And Morty",
                    onSearchClick = {}
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                when (uiState) {
                    is BaseViewState.Data -> {
                        HomeScreenContent(
                            vm,
                            uiState.cast<BaseViewState.Data<HomeScreenViewState>>().value
                        )
                    }

                    is BaseViewState.Empty -> {}
                    is BaseViewState.Error -> {}
                    is BaseViewState.Loading -> {
                        ProgressIndicator()
                    }

                    else -> {}
                }
            }
        }
    }

}