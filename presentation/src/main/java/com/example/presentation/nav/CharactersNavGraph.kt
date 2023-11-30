package com.example.presentation.characters.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.Characters
import com.example.presentation.characters.ui.HomeScreenUi

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
            HomeScreenUi()
        }
    }
}