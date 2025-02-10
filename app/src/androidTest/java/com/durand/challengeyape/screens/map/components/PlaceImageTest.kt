package com.durand.challengeyape.screens.map.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class PlaceImageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun placeImage_isDisplayedCorrectly() {
        val testImageUrl = "https://via.placeholder.com/250"

        composeTestRule.setContent {
            PlaceImage(imageUrl = testImageUrl)
        }

        // Verifica que la imagen con testTag "PlaceImage" se muestra
        composeTestRule.onNodeWithTag("PlaceImage").assertIsDisplayed()
    }
}
