package com.durand.challengeyape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.durand.challengeyape.screens.DetailScreen
import com.durand.challengeyape.screens.HomeScreen
import com.durand.challengeyape.screens.MapScreen
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengeYapeTheme {
                val navController = rememberNavController()
                val viewModel = RecipesViewModel()
                NavHost(navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController, viewModel) }
                    composable("detail/{recipeId}") { backStackEntry ->
                        val recipeId =
                            backStackEntry.arguments?.getString("recipeId")?.toIntOrNull() ?: 0
                        DetailScreen(recipeId, navController)
                    }
                    composable("map/{location}") { backStackEntry ->
                        val location = backStackEntry.arguments?.getString("location") ?: "Unknown"
                        MapScreen(location)
                    }
                }
            }
        }
    }
}