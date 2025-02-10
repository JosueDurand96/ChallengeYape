package com.durand.challengeyape.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.durand.challengeyape.navigation.MapData

// Map Screen
@Composable
fun MapScreen(
    data: MapData
) {
    // Implementación de la pantalla de mapa con Google Maps
    Text(
        text = "Mapa de ${data.info.nombre}",
        )
}
