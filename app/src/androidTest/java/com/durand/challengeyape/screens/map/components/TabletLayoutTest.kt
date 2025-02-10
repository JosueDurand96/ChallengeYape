package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.durand.challengeyape.navigation.MapData
import com.durand.challengeyape.navigation.MapDataInfo
import com.google.android.gms.maps.model.LatLng
import org.junit.Rule
import org.junit.Test

class TabletLayoutTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tabletLayout_displaysAllComponentsCorrectly() {
        val testData = MapData(
            info = MapDataInfo(
                nombre = "Plaza Mayor",
                descripcion = "Centro histórico y cultural",
                imagen = "https://via.placeholder.com/150",
                ciudad = "Lima",
                pais = "Perú",
                latitud = "-12.0464",
                longitud = "-77.0428"
            )
        )

        val testLocation = LatLng(-12.0464, -77.0428) // Ubicación de Lima, Perú

        composeTestRule.setContent {
            TabletLayout(data = testData, location = testLocation)
        }

        // Verifica que los subcomponentes se muestran en pantalla
        composeTestRule.onNodeWithTag("PlaceImage").assertIsDisplayed()
        composeTestRule.onNodeWithTag("PlaceDetails").assertIsDisplayed()
        composeTestRule.onNodeWithTag("PlaceMap").assertIsDisplayed()
    }
}