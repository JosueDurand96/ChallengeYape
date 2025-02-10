package com.durand.challengeyape.screens.map

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.navigation.MapData
import com.durand.challengeyape.navigation.MapDataInfo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MapScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var testData: MapData

    @Before
    fun setUp() {
        testData = MapData(
            info = MapDataInfo(
                nombre = "Plaza Mayor",
                descripcion = "descripcion",
                imagen = "imagen",
                ciudad = "Madrid",
                pais = "España",
                latitud = "40.416775",
                longitud = "-3.703790",
            )
        )
    }

    @Test
    fun verifyTopBarDisplaysCorrectly() {
        composeTestRule.setContent {
            MapScreen(data = testData, onBackPress = {})
        }

        composeTestRule.waitForIdle()

        // Verifica que el nombre de la ubicación se muestra en la TopBar
        composeTestRule.onNodeWithText("Plaza Mayor").assertExists()
    }

    @Test
    fun verifyBackPressIsTriggered() {
        var backPressed = false
        composeTestRule.setContent {
            MapScreen(data = testData, onBackPress = { backPressed = true })
        }

        composeTestRule.waitForIdle()

        // Simula el clic en el botón de retroceso de la TopBar
        composeTestRule.onNodeWithContentDescription("Back").performClick()

        // Verifica que la acción de retroceso fue ejecutada
        assert(backPressed)
    }

    @Test
    fun verifyCorrectLayoutIsDisplayed() {
        composeTestRule.setContent {
            MapScreen(data = testData, onBackPress = {})
        }

        composeTestRule.waitForIdle() // Espera a que Compose termine de renderizar

        val windowWidth = composeTestRule.activity.resources.configuration.screenWidthDp
        val isCompact = windowWidth < 600 // Consideramos 600dp como referencia

        if (isCompact) {
            composeTestRule.onNodeWithTag("MobileLayout").assertExists()
        } else {
            composeTestRule.onNodeWithTag("TabletLayout").assertExists()
        }
    }
}