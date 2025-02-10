package com.durand.challengeyape.screens.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.durand.challengeyape.navigation.PersonalData

// Componente para los detalles de la receta
@Composable
fun RecipeDetails(data: PersonalData) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = data.info.nombre,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = data.info.descripcion,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "${data.info.ciudad}, ${data.info.pais}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}