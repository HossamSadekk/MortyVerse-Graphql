package com.example.presentation.ui.CharacterDetails

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.presentation.R
import com.example.presentation.ui.components.CharacterDetailsContent
import com.example.presentation.ui.components.ErrorView
import com.example.presentation.ui.components.ProgressIndicator
import com.example.presentation.ui.components.cast
import com.example.rickandmorty.ui.AppBarWithBackIcon
import com.exampleM.common.mvi.BaseViewState
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersDetailsScreen(
    onBackPressed: () -> Unit,
    vm: CharacterDetailsViewModel = koinViewModel()
) {
    KoinAndroidContext() {
        val uiState by vm.uiState.collectAsState()

        Scaffold(
            topBar = {
                AppBarWithBackIcon(
                    title = "Character Details",
                    backIcon = R.drawable.back_icon,
                ) {
                    onBackPressed.invoke()
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                when (uiState) {
                    is BaseViewState.Data -> {
                        Log.d(
                            "hossam",
                            uiState.cast<BaseViewState.Data<CharacterDetailsState>>().value.characterDetails.name
                        )
                        CharacterDetailsContent(
                            uiState.cast<BaseViewState.Data<CharacterDetailsState>>().value
                        )

                    }

                    is BaseViewState.Empty -> {}
                    is BaseViewState.Error -> {
                        ErrorView(uiState.cast<BaseViewState.Error>().throwable.localizedMessage) {
                            // refresh
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