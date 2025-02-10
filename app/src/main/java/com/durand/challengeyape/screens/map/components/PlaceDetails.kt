package com.durand.challengeyape.screens.map.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.MapData

// Componente para los detalles del lugar
@Composable
fun PlaceDetails(data: MapData) {
    Column(modifier = Modifier
        .testTag("PlaceDetails")
        .padding(horizontal = 16.dp)) {
        Text(
            text = data.info.nombre,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = data.info.descripcion,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}