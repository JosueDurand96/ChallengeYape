package com.durand.challengeyape.screens.map.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.MapData
import com.google.android.gms.maps.model.LatLng

// Diseño para tablets y pantallas grandes (Medium y Expanded)
@Composable
fun TabletLayout(data: MapData, location: LatLng) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
        PlaceMap(location, modifier = Modifier.weight(1f))
    }
}