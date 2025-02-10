package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.durand.challengeyape.navigation.MapData
import com.durand.challengeyape.navigation.MapDataInfo
import com.google.android.gms.maps.model.LatLng
import org.junit.Rule
import org.junit.Test

class MobileLayoutTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mobileLayout_displaysCorrectUIElements() {
        val fakeData = MapData(
            info = MapDataInfo(
                nombre = "Lugar de Prueba",
                descripcion = "Descripción de prueba",
                imagen = "https://via.placeholder.com/150",
                ciudad = "Lima",
                pais = "Peru",
                latitud = "37.7749",
                longitud = "-122.4194"
            )
        )
        val fakeLocation = LatLng(fakeData.info.latitud.toDouble(), fakeData.info.longitud.toDouble())

        composeTestRule.setContent {
            MobileLayout(data = fakeData, location = fakeLocation, modifier = Modifier)
        }

        composeTestRule.waitForIdle()

        // Verificar que los elementos clave están en la pantalla
        composeTestRule.onNodeWithText("Lugar de Prueba").assertExists()
        composeTestRule.onNodeWithText("Descripción de prueba").assertExists()
        composeTestRule.onNodeWithTag("PlaceImage").assertExists() //
        composeTestRule.onNodeWithTag("PlaceMap").assertExists()
    }

}
