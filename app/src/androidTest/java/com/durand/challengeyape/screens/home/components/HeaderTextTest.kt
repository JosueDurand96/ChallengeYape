package com.durand.challengeyape.screens.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeaderTextTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun verifyHeaderTextIsDisplayed() {
        val testTitle = "Recetas del Mundo"

        composeTestRule.setContent {
            ChallengeYapeTheme {
                HeaderText(title = testTitle)
            }
        }

        // Verifica que el texto se muestra correctamente
        composeTestRule.onNodeWithText(testTitle).assertIsDisplayed()
    }
}