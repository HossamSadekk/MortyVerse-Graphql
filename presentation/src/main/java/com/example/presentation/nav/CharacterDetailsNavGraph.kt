package com.example.presentation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.common.navigation.Characters
import com.example.presentation.ui.CharacterDetails.CharactersDetailsScreen

fun NavGraphBuilder.characterDetails(onNavigateBack: () -> Unit) {
    composable(Characters.CHARACTERDETAILS + "/{characterId}",
        arguments = listOf(
            navArgument(
                name = "characterId",
            ) {
                type = NavType.StringType
            }
        )) { backStackEntry ->
        val characterId = backStackEntry.arguments?.getInt("characterId")
        characterId?.let {
            CharactersDetailsScreen(
                onBackPressed = { onNavigateBack.invoke() }
            )
        }
    }
}