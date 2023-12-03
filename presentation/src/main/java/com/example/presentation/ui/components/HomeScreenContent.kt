package com.example.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.network.HttpException
import com.example.presentation.ui.homeScreen.HomeScreenViewModel
import com.example.presentation.ui.homeScreen.HomeScreenViewState
import java.io.IOException
import androidx.compose.foundation.layout.*

@Composable
fun HomeScreenContent(
    viewModel: HomeScreenViewModel,
    uiState: HomeScreenViewState,
    navigate: (String) -> Unit
) {
    val characters = uiState.charactersPagedData.collectAsLazyPagingItems()
    Log.d("hossam", characters.itemCount.toString())
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        when (characters.loadState.refresh) {
            is LoadState.Loading -> {
                items(20) {
                    ShimmerItem()
                }
            }
            is LoadState.Error -> {
                val error = characters.loadState.refresh as LoadState.Error
                val errorMessage = when (error.error) {
                    is HttpException -> "Sorry, Something went wrong!\nTap to retry"
                    is IOException -> "Connection failed. Tap to retry!"
                    else -> "Failed! Tap to retry!"
                }
                viewModel.handleError(Exception(errorMessage))
            }
            else -> {
                items(count = characters.itemCount) {
                    characters[it]?.let {
                        CharacterRow(it) {id ->
                            navigate(id)
                        }
                    }
                }
            }
        }

    }

}

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}


