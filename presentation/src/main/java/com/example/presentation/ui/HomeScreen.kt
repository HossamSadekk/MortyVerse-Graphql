package com.example.presentation.characters.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.R
import com.example.rickandmorty.ui.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUi(){
    Scaffold(
        topBar = {
            AppBar(
                icon1 = R.drawable.round_search_24,
                title = "Rick And Morty",
                onSearchClick = {}
            )
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

        }

    }
}