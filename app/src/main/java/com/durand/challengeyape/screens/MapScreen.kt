package com.durand.challengeyape.screens

import androidx.compose.material3.Text
import com.durand.challengeyape.navigation.MapData
import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import com.google.android.gms.maps.model.CameraPosition
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ContextCastToActivity",
    "UnusedBoxWithConstraintsScope"
)
@Composable
fun MapScreen(
    data: MapData,
    onBackPress: () -> Unit
) {
    val location = LatLng(data.info.latitud.toDouble(), data.info.longitud.toDouble()) // Coordenadas recibidas
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current as Activity)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Ubicación de ${data.info.nombre}") },
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
                    Column {
                        PlaceImage(data.info.imagen)
                        PlaceDetails(data)
                        Spacer(modifier = Modifier.height(16.dp))
                        PlaceMap(location)
                    }
                }
                WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
                    // Diseño para tablets y pantallas grandes (Medium y Expanded)
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 16.dp)
                        ) {
                            PlaceImage(data.info.imagen)
                            Spacer(modifier = Modifier.height(16.dp))
                            PlaceDetails(data)
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                        ) {
                            PlaceMap(location)
                        }
                    }
                }
            }
        }
    }
}

// Componente para la imagen del lugar
@Composable
fun PlaceImage(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Imagen del lugar",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}

// Componente para los detalles del lugar
@Composable
fun PlaceDetails(data: MapData) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
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

// Componente para el mapa con marcador
@Composable
fun PlaceMap(location: LatLng) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(location, 12f)
            }
        ) {
            Marker(
                state = MarkerState(position = location),
                title = "Ubicación",
                snippet = "Este es el lugar indicado"
            )
        }
    }
}
