package com.durand.challengeyape.screens.detail.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.navigation.PersonalData
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeDetailsTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val testPersonalData = PersonalData(
        info = PersonalDataInfo(
            nombre = "Pizza",
            descripcion = "Masa y queso con tomate",
            imagen = "https://fakeurl.com/pizza.jpg",
            ciudad = "Lima",
            pais = "Peru",
            latitud = "10.0",
            longitud = "20.0"
        )
    )

    @Before
    fun setup() {
        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeDetails(data = testPersonalData)
            }
        }
    }

    @Test
    fun verifyRecipeNameIsDisplayed() {
        composeTestRule.onNodeWithText("Pizza").assertExists()
    }

    @Test
    fun verifyRecipeDescriptionIsDisplayed() {
        composeTestRule.onNodeWithText("Masa y queso con tomate").assertExists()
    }

    @Test
    fun verifyRecipeLocationIsDisplayed() {
        composeTestRule.onNodeWithText("Lima, Peru").assertExists()
    }
}