package com.durand.challengeyape.screens.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.domain.model.Recipe
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeItemTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun verifyRecipeItemIsDisplayed() {
        val testRecipe = Recipe(
            nombre = "Pizza",
            descripcion = "Masa y queso",
            imagen = "https://fakeurl.com",
            ciudad = "Lima",
            pais = "Peru",
            latitud = 10.0,
            longitud = 20.0
        )

        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeItem(recipe = testRecipe, onClick = {})
            }
        }

        // Verifica que el nombre de la receta se muestra correctamente
        composeTestRule.onNodeWithText("Pizza").assertIsDisplayed()
    }

    @Test
    fun verifyRecipeItemClickWorks() {
        val testRecipe = Recipe(
            nombre = "Pizza",
            descripcion = "Masa y queso",
            imagen = "https://fakeurl.com",
            ciudad = "Lima",
            pais = "Peru",
            latitud = 10.0,
            longitud = 20.0
        )
        val mockOnClick: () -> Unit = mockk(relaxed = true)

        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeItem(recipe = testRecipe, onClick = mockOnClick)
            }
        }

        // Simula un clic en la tarjeta
        composeTestRule.onNodeWithText("Pizza").performClick()

        // Verifica que el callback fue llamado
        verify { mockOnClick.invoke() }
    }
}
