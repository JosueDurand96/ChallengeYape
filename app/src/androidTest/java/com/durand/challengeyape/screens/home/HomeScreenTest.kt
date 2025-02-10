package com.durand.challengeyape.screens.home

import androidx.compose.ui.test.*
import com.durand.challengeyape.viewmodel.RecipesViewModel
import com.durand.challengeyape.viewmodel.UiState
import com.durand.domain.model.Recipe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.junit4.createComposeRule

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: RecipesViewModel
    private lateinit var uiStateFlow: MutableStateFlow<UiState<List<Recipe>>>

    @Before
    fun setUp() {
        // Mock del ViewModel
        viewModel = mockk(relaxed = true)
        uiStateFlow = MutableStateFlow(UiState.Loading)

        every { viewModel.uiState } returns uiStateFlow
    }

    @Test
    fun verifyLoadingStateIsDisplayed() {
        composeTestRule.setContent {
            HomeScreen(viewModel = viewModel, navigateToDescription = {})
        }

        composeTestRule.waitForIdle()

        // Verifica que el indicador de carga se muestra
        composeTestRule.onNodeWithTag("LoadingIndicator").assertExists()
    }

    @Test
    fun verifyRecipesListIsDisplayed() {
        // Simula el estado de éxito con recetas
        val recipes = listOf(
            Recipe("Pizza", "Deliciosa pizza", "pizza.jpg", "Roma", "Italia", 41.9028, 12.4964),
            Recipe("Sushi", "Sushi japonés", "sushi.jpg", "Tokio", "Japón", 35.6895, 139.6917)
        )
        uiStateFlow.value = UiState.Success(recipes)

        composeTestRule.setContent {
            HomeScreen(viewModel = viewModel, navigateToDescription = {})
        }

        composeTestRule.waitForIdle()

        // Verifica que las recetas se muestran en la pantalla
        composeTestRule.onNodeWithText("Pizza").assertExists()
        composeTestRule.onNodeWithText("Sushi").assertExists()
    }

    @Test
    fun verifyErrorStateIsDisplayed() {
        // Simula un error en la UI
        val errorMessage = "Error de conexión"
        uiStateFlow.value = UiState.Error(errorMessage)

        composeTestRule.setContent {
            HomeScreen(viewModel = viewModel, navigateToDescription = {})
        }

        composeTestRule.waitForIdle()

        // Verifica que el mensaje de error se muestra
        composeTestRule.onNodeWithText("Error: $errorMessage").assertExists()
    }

    @Test
    fun verifySearchFiltersResults() {
        // Simula el estado de éxito con recetas
        val recipes = listOf(
            Recipe("Pizza", "Comida italiana", "pizza.jpg", "Roma", "Italia", 41.9028, 12.4964),
            Recipe("Sushi", "Plato japonés", "sushi.jpg", "Tokio", "Japón", 35.6895, 139.6917)
        )
        uiStateFlow.value = UiState.Success(recipes)

        composeTestRule.setContent {
            HomeScreen(viewModel = viewModel, navigateToDescription = {})
        }

        composeTestRule.waitForIdle()

        // Introduce texto en el buscador
        composeTestRule.onNodeWithTag("SearchBar").performTextInput("Pizza")

        composeTestRule.waitForIdle()

        // Verifica que solo "Pizza" está visible y "Sushi" no
        composeTestRule.onNodeWithText("Sushi").assertDoesNotExist()
    }
}