package com.durand.challengeyape.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.durand.challengeyape.viewmodel.RecipesViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.durand.challengeyape.screens.HomeScreen

@Composable
fun NavigationWrapper(
    viewModel: RecipesViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = FirstModal) {
        composable<FirstModal> {
            HomeScreen(
                viewModel = viewModel,
            )
        }
    }
}