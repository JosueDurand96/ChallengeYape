package com.durand.challengeyape.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalContext
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.viewmodel.RecipesViewModel
import com.durand.domain.model.Recipe
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import coil.compose.rememberAsyncImagePainter

@SuppressLint("ContextCastToActivity", "UnusedBoxWithConstraintsScope")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen(
    viewModel: RecipesViewModel,
    navigateToDescription: (PersonalDataInfo) -> Unit
) {
    val recipes by viewModel.recipes.collectAsState(initial = emptyList())

    // Estado para la búsqueda
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    // Obtener tamaño de la pantalla para adaptar el diseño
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current as Activity)

    // Filtrar recetas en base a la búsqueda
    val filteredRecipes = recipes.filter { recipe ->
        recipe.nombre.contains(searchQuery.text, ignoreCase = true) ||
                recipe.descripcion.contains(searchQuery.text, ignoreCase = true)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Recetas del Mundo",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
        )

        // Buscador
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar receta...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            singleLine = true
        )

        // Diseño flexible: Lista en móviles, grilla en tablets
        BoxWithConstraints {
            if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                LazyColumn {
                    items(filteredRecipes) { recipe ->
                        RecipeItem(recipe, onClick = {
                            navigateToDescription(
                                PersonalDataInfo(
                                    nombre = recipe.nombre,
                                    descripcion = recipe.descripcion,
                                    imagen = recipe.imagen,
                                    ciudad = recipe.ciudad,
                                    pais = recipe.pais,
                                    latitud = recipe.latitud.toString(),
                                    longitud = recipe.longitud.toString()
                                )
                            )
                        })
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 180.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(filteredRecipes) { recipe ->
                        RecipeItem(recipe, onClick = {
                            navigateToDescription(
                                PersonalDataInfo(
                                    nombre = recipe.nombre,
                                    descripcion = recipe.descripcion,
                                    imagen = recipe.imagen,
                                    ciudad = recipe.ciudad,
                                    pais = recipe.pais,
                                    latitud = recipe.latitud.toString(),
                                    longitud = recipe.longitud.toString()
                                )
                            )
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(recipe.imagen),
                contentDescription = recipe.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = recipe.nombre,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}