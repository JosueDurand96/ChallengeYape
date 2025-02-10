package com.durand.domain.usecase

import app.cash.turbine.test
import com.durand.domain.model.Recipe
import com.durand.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class GetRecipesUseCaseTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var repository: RecipeRepository

    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @Before
    fun setup() {
        getRecipesUseCase = GetRecipesUseCase(repository)
    }

    @Test
    fun `execute should return list of recipes`() = runTest {
        // Simulamos la respuesta del repositorio con datos de prueba
        val mockRecipes = listOf(
            Recipe(
                nombre = "Pasta Carbonara",
                descripcion = "Receta clásica italiana",
                imagen = "https://example.com/pasta.jpg",
                ciudad = "Roma",
                pais = "Italia",
                latitud = 41.9028,
                longitud = 12.4964
            ),
            Recipe(
                nombre = "Tacos",
                descripcion = "Tacos tradicionales",
                imagen = "https://example.com/tacos.jpg",
                ciudad = "Ciudad de México",
                pais = "México",
                latitud = 19.4326,
                longitud = -99.1332
            )
        )

        // Configurar el mock para devolver un Flow con los datos simulados
        `when`(repository.getRecipes()).thenReturn(flowOf(mockRecipes))

        // Probamos el flujo usando Turbine
        getRecipesUseCase.execute().test {
            assertEquals(mockRecipes, awaitItem()) // Verificamos la lista emitida
            awaitComplete() // Confirmamos que el Flow se completó correctamente
        }
    }
}