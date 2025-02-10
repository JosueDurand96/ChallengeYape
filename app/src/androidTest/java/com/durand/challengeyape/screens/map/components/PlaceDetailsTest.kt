package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.durand.challengeyape.navigation.MapData
import com.durand.challengeyape.navigation.MapDataInfo
import org.junit.Rule
import org.junit.Test

class PlaceDetailsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun placeDetails_displaysCorrectData() {
        val testMapData = MapData(
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

        composeTestRule.setContent {
            PlaceDetails(data = testMapData)
        }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Lugar de Prueba").assertIsDisplayed()
        composeTestRule.onNodeWithText("Descripción de prueba").assertIsDisplayed()
    }
}