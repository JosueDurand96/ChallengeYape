package com.durand.challengeyape.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

// Componente para la imagen de la receta
@Composable
fun RecipeImage(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Imagen de la receta",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .testTag("RecipeImage") // <-- Asegurar que el test lo detecte
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}