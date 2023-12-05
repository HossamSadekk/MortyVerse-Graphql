package com.example.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.common.navigation.Characters
import com.example.presentation.ui.CharacterSearch.CharactersSearch

fun NavGraphBuilder.characterSearch(navigate: (String) -> Unit, onBackPressed: () -> Unit) {
    composable(Characters.CHARACTERSEARCH,
        arguments = listOf(
            navArgument(
                name = "characterId",
            ) {
                type = NavType.StringType
            }
        )) {
        CharactersSearch(navigateToDetails = {
            navigate(it)
        }, onBackPressed = {
            onBackPressed
        })
    }
}