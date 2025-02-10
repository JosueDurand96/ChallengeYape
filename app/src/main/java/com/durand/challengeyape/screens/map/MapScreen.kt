package com.durand.challengeyape.screens.map

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.durand.challengeyape.navigation.MapData
import com.google.android.gms.maps.model.LatLng
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.durand.challengeyape.screens.map.components.MapTopBar
import com.durand.challengeyape.screens.map.components.MobileLayout
import com.durand.challengeyape.screens.map.components.TabletLayout

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedBoxWithConstraintsScope",
    "ContextCastToActivity"
)
@Composable
fun MapScreen(
    data: MapData,
    onBackPress: () -> Unit
) {
    val location = LatLng(data.info.latitud.toDouble(), data.info.longitud.toDouble())
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current as Activity)

    Scaffold(
        topBar = { MapTopBar(data.info.nombre, onBackPress) }
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    MobileLayout(data, location)
                }
                WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
                    TabletLayout(data, location)
                }
            }
        }
    }
}