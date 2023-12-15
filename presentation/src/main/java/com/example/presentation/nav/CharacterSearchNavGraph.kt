package com.example.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.common.navigation.Characters
import com.example.presentation.ui.CharacterSearch.CharactersSearch

fun NavGraphBuilder.characterSearch(navigate: (String) -> Unit, onBackPressed: () -> Unit) {
    composable(route = Characters.CHARACTERSEARCH) {
        CharactersSearch(navigateToDetails = {
            navigate(it)
        }, onBackPressed = {
            onBackPressed.invoke()
        })
    }
}