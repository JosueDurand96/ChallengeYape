package com.durand.challengeyape.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.screens.home.toPersonalDataInfo
import com.durand.domain.model.Recipe

// Lista de recetas con diseño adaptable (Lista en móviles, Grid en tablets)
@Composable
fun RecipeList(
    recipes: List<Recipe>,
    windowSizeClass: WindowSizeClass,
    navigateToDescription: (PersonalDataInfo) -> Unit
) {
    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        LazyColumn {
            items(recipes) { recipe ->
                RecipeItem(recipe) { navigateToDescription(recipe.toPersonalDataInfo()) }
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 180.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(recipes) { recipe ->
                RecipeItem(recipe) { navigateToDescription(recipe.toPersonalDataInfo()) }
            }
        }
    }
}