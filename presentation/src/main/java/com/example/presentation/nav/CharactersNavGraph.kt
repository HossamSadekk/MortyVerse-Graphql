package com.example.presentation.characters.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.navigation.Characters
import com.example.presentation.characters.ui.HomeScreenUi
import com.example.presentation.nav.characterDetails
import com.example.presentation.nav.characterSearch

fun NavGraphBuilder.charactersGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Characters.CHARACTERlIST,
        route = Characters.CHARACTERSGRAPH
    ) {
        composable(
            route = Characters.CHARACTERlIST
        ) {
            HomeScreenUi(searchScreen = {
                navHostController.navigate(Characters.CHARACTERSEARCH)
            }, navigate = {
                navHostController.navigate(Characters.CHARACTERDETAILS + "/$it")
            })
        }
        characterDetails(onNavigateBack = {
            navHostController.popBackStack()
        })

        characterSearch(navigate = { characterId ->
            navHostController.navigate(Characters.CHARACTERDETAILS + "/$characterId")
        }, onBackPressed = {
            navHostController.popBackStack()
        })

    }
}