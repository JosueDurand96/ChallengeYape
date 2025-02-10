package com.durand.challengeyape.screens.home

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.viewmodel.RecipesViewModel
import com.durand.challengeyape.viewmodel.UiState
import com.durand.domain.model.Recipe
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Alignment
import com.durand.challengeyape.screens.home.components.HeaderText
import com.durand.challengeyape.screens.home.components.RecipeList

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen(
    viewModel: RecipesViewModel,
    navigateToDescription: (PersonalDataInfo) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current as Activity)

    Column(modifier = Modifier.padding(16.dp)) {
        HeaderText("Recetas del Mundo")

        com.durand.challengeyape.screens.home.components.SearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it }
        )

        when (uiState) {
            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is UiState.Success -> {
                val recipes = (uiState as UiState.Success<List<Recipe>>).data
                val filteredRecipes = recipes.filter { recipe ->
                    recipe.nombre.contains(searchQuery.text, ignoreCase = true) ||
                            recipe.descripcion.contains(searchQuery.text, ignoreCase = true)
                }
                RecipeList(
                    recipes = filteredRecipes,
                    windowSizeClass = windowSizeClass,
                    navigateToDescription = navigateToDescription
                )
            }
            is UiState.Error -> {
                val errorMessage = (uiState as UiState.Error).message
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error: $errorMessage", color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}

// Extensión para convertir `Recipe` a `PersonalDataInfo`
fun Recipe.toPersonalDataInfo(): PersonalDataInfo {
    return PersonalDataInfo(
        nombre = nombre,
        descripcion = descripcion,
        imagen = imagen,
        ciudad = ciudad,
        pais = pais,
        latitud = latitud.toString(),
        longitud = longitud.toString()
    )
}