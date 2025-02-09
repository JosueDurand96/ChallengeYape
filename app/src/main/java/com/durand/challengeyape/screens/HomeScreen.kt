package com.durand.challengeyape.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.durand.challengeyape.viewmodels.RecipesViewModel
import com.durand.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(viewModel: RecipesViewModel) {
    //val viewModel: RecipesViewModel = RecipesViewModel()
    val recipes by viewModel.recipes.collectAsState(initial = emptyList())
   // val recipes by viewModel.recipes.observeAsState(emptyList())
    LazyColumn {
        items(recipes.size) { index ->
            val recipe = recipes[index]
            RecipeItem(recipe, onClick = {
                //navController.navigate("detail/${recipe.id}")
            })
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
                painter = rememberImagePainter(recipe.imagen),
                contentDescription = recipe.nombre,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = recipe.nombre, style = MaterialTheme.typography.headlineSmall)
        }
    }
}