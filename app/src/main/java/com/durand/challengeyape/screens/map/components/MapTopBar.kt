package com.durand.challengeyape.screens.map.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

// Componente para el TopAppBar con botón de retroceso
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapTopBar(title: String, onBackPress: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Ubicación de $title") },
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
            }
        }
    )
}