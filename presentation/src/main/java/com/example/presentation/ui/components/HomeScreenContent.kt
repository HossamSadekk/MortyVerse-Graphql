package com.example.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.ui.homeScreen.HomeScreenViewModel
import com.example.presentation.ui.homeScreen.HomeScreenViewState

@Composable
fun HomeScreenContent(
    viewModel: HomeScreenViewModel,
    uiState: HomeScreenViewState,
) {
    val characters = uiState.charactersPagedData.collectAsLazyPagingItems()
    Log.d("hossam",characters.itemCount.toString())
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(count = characters.itemCount) {
            characters[it]?.let {
                CharacterRow(it){
                }
            }
        }
    }

}
inline fun <reified T : Any> Any.cast(): T {
    return this as T
}


