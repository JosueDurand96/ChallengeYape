package com.durand.challengeyape.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.durand.challengeyape.Recipe
import com.durand.challengeyape.RecipesViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: RecipesViewModel) {
    val recipes = viewModel.recipes.observeAsState(initial = emptyList())
    LazyColumn {
        items(recipes.value.size) { index ->
            val recipe = recipes.value[index]
            RecipeItem(recipe, onClick = { navController.navigate("detail/${recipe.id}") })
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    val imagePainter = painterResource(id = recipe.image) // Aquí sí podemos usar @Composable
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(painter = imagePainter, contentDescription = recipe.name)
            Text(text = recipe.name, style = MaterialTheme.typography.headlineSmall)
        }
    }
}