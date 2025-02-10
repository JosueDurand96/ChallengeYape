package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MapTopBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mapTopBar_displaysCorrectTitle() {
        // Arrange
        val title = "Mi Ubicación"

        // Act
        composeTestRule.setContent {
            MapTopBar(title = title, onBackPress = {})
        }

        // Assert: Verifica que el título se muestra correctamente
        composeTestRule.onNodeWithText("Ubicación de $title").assertExists()
    }

    @Test
    fun mapTopBar_backButtonIsClickable() {
        var backButtonClicked = false
        val title = "Prueba"

        composeTestRule.setContent {
            MapTopBar(title = title, onBackPress = { backButtonClicked = true })
        }

        // Perform action: Click en el botón de retroceso
        composeTestRule.onNodeWithContentDescription("Back").performClick()

        // Assert: Verifica que la acción de onBackPress fue llamada
        assertTrue(backButtonClicked)
    }
}