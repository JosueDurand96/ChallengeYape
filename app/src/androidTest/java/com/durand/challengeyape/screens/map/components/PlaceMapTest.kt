package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.google.android.gms.maps.model.LatLng
import org.junit.Rule
import org.junit.Test

class PlaceMapTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun placeMap_isDisplayedCorrectly() {
        val testLocation = LatLng(-12.0464, -77.0428) // Ejemplo: Ubicación en Lima, Perú

        composeTestRule.setContent {
            PlaceMap(location = testLocation)
        }

        // Verifica que el componente con testTag "PlaceMap" se muestra en pantalla
        composeTestRule.onNodeWithTag("PlaceMap").assertIsDisplayed()
    }
}