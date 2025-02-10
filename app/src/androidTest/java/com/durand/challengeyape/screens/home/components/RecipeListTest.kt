package com.durand.challengeyape.screens.home.components

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.screens.home.toPersonalDataInfo
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import com.durand.domain.model.Recipe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeListTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val testRecipes = listOf(
        Recipe(
            nombre = "Pizza",
            descripcion = "Masa y queso",
            imagen = "https://fakeurl.com",
            ciudad = "Lima",
            pais = "Peru",
            latitud = 10.0,
            longitud = 20.0
        ),
        Recipe(
            nombre = "Sushi",
            descripcion = "Pescado y arroz",
            imagen = "https://fakeurl.com",
            ciudad = "Tokio",
            pais = "Japón",
            latitud = 35.0,
            longitud = 139.0
        )
    )

    // Mock de WindowSizeClass para simular diferentes tamaños de pantalla
    val mockWindowSizeClass: WindowSizeClass = mockk {
        every { widthSizeClass } returns WindowWidthSizeClass.Compact
    }
    val mockNavigateToDescription: (PersonalDataInfo) -> Unit = mockk(relaxed = true)


    @Test
    fun verifyRecipeListIsDisplayedAsListOnCompactScreen() {
        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeList(
                    recipes = testRecipes,
                    windowSizeClass = mockWindowSizeClass,
                    navigateToDescription = mockNavigateToDescription
                )
            }
        }

        // Verifica que los nombres de las recetas están en la pantalla
        composeTestRule.onNodeWithText("Pizza").assertIsDisplayed()
        composeTestRule.onNodeWithText("Sushi").assertIsDisplayed()
    }

    @Test
    fun verifyRecipeListIsDisplayedAsGridOnExpandedScreen() {
        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeList(
                    recipes = testRecipes,
                    windowSizeClass = mockWindowSizeClass,
                    navigateToDescription = mockNavigateToDescription
                )
            }
        }

        // Verifica que los nombres de las recetas están en la pantalla
        composeTestRule.onNodeWithText("Pizza").assertIsDisplayed()
        composeTestRule.onNodeWithText("Sushi").assertIsDisplayed()
    }

    @Test
    fun verifyRecipeItemClickWorks() {
        val mockNavigateToDescription: (PersonalDataInfo) -> Unit = mockk(relaxed = true)

        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeList(
                    recipes = testRecipes,
                    windowSizeClass = mockWindowSizeClass,
                    navigateToDescription = mockNavigateToDescription
                )
            }
        }

        // Simula un clic en la receta "Pizza"
        composeTestRule.onNodeWithText("Pizza").performClick()

        // Verifica que se llamó a la función con el objeto correcto
        verify { mockNavigateToDescription.invoke(testRecipes[0].toPersonalDataInfo()) }
    }
}