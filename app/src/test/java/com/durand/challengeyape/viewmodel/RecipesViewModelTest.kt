package com.durand.challengeyape.viewmodel

import app.cash.turbine.test
import com.durand.domain.model.Recipe
import com.durand.domain.usecase.GetRecipesUseCase
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow

@OptIn(ExperimentalCoroutinesApi::class)
class RecipesViewModelTest {

    private val testDispatcher = StandardTestDispatcher() // Dispatcher de prueba
    private lateinit var viewModel: RecipesViewModel
    private val getRecipesUseCase: GetRecipesUseCase = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher) // Forzar Dispatchers.Main en test

        // Simular el flujo de datos con un pequeño delay para garantizar `UiState.Loading`
        every { getRecipesUseCase.execute() } returns flow {
            delay(100) // Simula un pequeño retraso
            emit(fakeRecipes)
        }

        viewModel = RecipesViewModel(getRecipesUseCase) // Instanciar el ViewModel
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Restaurar Dispatchers.Main después del test
    }

    @Test
    fun `fetchRecipes should update uiState with Success`() = runTest {
        viewModel.uiState.test {
            assertEquals(UiState.Loading, awaitItem()) // Verifica que primero se emite `Loading`

            advanceUntilIdle() // Avanza el tiempo para que las corrutinas terminen

            assertEquals(UiState.Success(fakeRecipes), awaitItem()) // Luego se emite `Success`
        }
    }

    companion object {
        private val fakeRecipes = listOf(
            Recipe("Pizza", "Masa y queso", "https://fakeurl.com", "Lima", "Peru", 10.0, 20.0),
            Recipe("Sushi", "Arroz y pescado", "https://fakeurl.com", "Tokyo", "Japón", 30.0, 40.0)
        )
    }
}
