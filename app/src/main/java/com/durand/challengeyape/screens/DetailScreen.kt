package com.durand.challengeyape.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

@SuppressLint("UnusedBoxWithConstraintsScope", "ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
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
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    // Diseño para móviles (Compact)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RecipeImage(data.info.imagen)
                        RecipeDetails(data)
                        MapButton(navigateToMap, data)
                    }
                }
                WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
                    // Diseño para tablets y pantallas grandes (Medium y Expanded)
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            RecipeImage(data.info.imagen)
                        }
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.Start
                        ) {
                            RecipeDetails(data)
                            Spacer(modifier = Modifier.height(20.dp))
                            MapButton(navigateToMap, data)
                        }
                    }
                }
            }
        }
    }
}

// Componente para la imagen de la receta
@Composable
fun RecipeImage(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Imagen de la receta",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}

// Componente para los detalles de la receta
@Composable
fun RecipeDetails(data: PersonalData) {
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

// Componente para el botón de mapa
@Composable
fun MapButton(navigateToMap: (MapDataInfo) -> Unit, data: PersonalData) {
    Button(
        onClick = {
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
        },
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Ver en el mapa")
    }
}
