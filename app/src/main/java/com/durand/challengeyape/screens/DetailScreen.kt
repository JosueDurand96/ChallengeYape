package com.durand.challengeyape.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Detail Screen
@Composable
fun DetailScreen(recipeId: Int, navController: NavController) {
    // Implementación de la pantalla de detalles
    Text("Detalles de la receta $recipeId")
}

