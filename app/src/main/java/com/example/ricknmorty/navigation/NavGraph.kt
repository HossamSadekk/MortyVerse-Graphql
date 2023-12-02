package com.example.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.common.navigation.Characters
import com.example.presentation.characters.nav.charactersGraph
@Composable
fun MainNavigation(navHostController: NavHostController) {

    NavHost(navController = navHostController,
        startDestination = Characters.CHARACTERSGRAPH) {

        charactersGraph(navHostController)

    }
}