package com.example.presentation.ui.CharacterSearch

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
import com.example.presentation.ui.components.ErrorView
import com.example.presentation.ui.components.ProgressIndicator
import com.example.presentation.ui.components.SearchScreenContent
import com.example.presentation.ui.components.cast
import com.example.rickandmorty.ui.CustomSearchBar
import com.exampleM.common.mvi.BaseViewState
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersSearch(
    vm: SearchViewModel = koinViewModel(),
    navigateToDetails: (String) -> Unit,
    onBackPressed: () -> Unit
) {
    KoinAndroidContext() {
        val searchString = vm.searchString.collectAsState().value
        val uiState by vm.uiState.collectAsState()

        LaunchedEffect(key1 = searchString) {
            if (searchString != "") {
                vm.onTriggerEvent(SearchScreenEvent.LoadCharactersList(searchString))
            }
        }
        Scaffold(
            topBar =
            {
                CustomSearchBar(
                    value = searchString,
                    placeholder = "Search Characters",
                    navigateUp = onBackPressed,
                    onValueChange = { name ->
                        vm.searchCharacter(name)
                    }
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
                        SearchScreenContent(
                            vm,
                            uiState.cast<BaseViewState.Data<SearchScreenViewState>>().value,
                            navigate = { id ->
                                navigateToDetails(id)
                            }
                        )
                    }

                    is BaseViewState.Empty -> {}
                    is BaseViewState.Error -> {
                        ErrorView(uiState.cast<BaseViewState.Error>().throwable.localizedMessage) {
                            vm.onTriggerEvent(SearchScreenEvent.RefreshScreen)
                        }
                    }

                    is BaseViewState.Loading -> {
                        ProgressIndicator()
                    }

                    else -> {}
                }

            }
        }
    }
}