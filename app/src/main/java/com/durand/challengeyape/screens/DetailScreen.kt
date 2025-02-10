package com.durand.challengeyape.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData

// Detail Screen
@Composable
fun DetailScreen(
    data: PersonalData,
    navigateToMap: (MapDataInfo) -> Unit
) {
    // Implementación de la pantalla de detalles
    Text(
        modifier = Modifier
            .clickable {
                navigateToMap(
                    MapDataInfo(
                        nombre = data.info.nombre,
                        descripcion = data.info.descripcion,
                        imagen = data.info.imagen,
                        ciudad = data.info.ciudad,
                        pais = data.info.pais,
                        latitud = data.info.latitud,
                        longitud = data.info.longitud
                    )
                )
            }
            .fillMaxSize(),
        text = "Detalles de la receta ${data.info.pais}")
}

