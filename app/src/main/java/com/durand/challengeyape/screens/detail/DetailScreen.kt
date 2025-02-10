package com.durand.challengeyape.screens.detail

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.durand.challengeyape.screens.detail.components.CompactLayout
import com.durand.challengeyape.screens.detail.components.ExpandedLayout

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    data: PersonalData,
    navigateToMap: (MapDataInfo) -> Unit,
    onBackPress: () -> Unit
) {
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current as Activity)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Descripción de la receta") },
                navigationIcon = {
                    IconButton(onClick = onBackPress) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> CompactLayout(data, navigateToMap, paddingValues)
            else -> ExpandedLayout(data, navigateToMap, paddingValues)
        }
    }
}

// Extensión para convertir `PersonalData` a `MapDataInfo`
fun PersonalData.toMapDataInfo(): MapDataInfo {
    return MapDataInfo(
        nombre = info.nombre,
        descripcion = info.descripcion,
        imagen = info.imagen,
        ciudad = info.ciudad,
        pais = info.pais,
        latitud = info.latitud,
        longitud = info.longitud
    )
}