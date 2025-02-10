package com.durand.challengeyape.screens.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData
import com.durand.challengeyape.screens.detail.toMapDataInfo

// Componente para el botón de mapa
@Composable
fun MapButton(navigateToMap: (MapDataInfo) -> Unit, data: PersonalData) {
    Button(
        onClick = { navigateToMap(data.toMapDataInfo()) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Ver en el mapa")
    }
}