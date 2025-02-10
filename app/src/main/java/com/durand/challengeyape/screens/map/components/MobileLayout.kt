package com.durand.challengeyape.screens.map.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.MapData
import com.google.android.gms.maps.model.LatLng

// Diseño para móviles (Compact)
@Composable
fun MobileLayout(data: MapData, location: LatLng, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PlaceImage(data.info.imagen)
        Spacer(modifier = Modifier.height(16.dp))
        PlaceDetails(data)
        Spacer(modifier = Modifier.height(16.dp))
        PlaceMap(location)
    }
}