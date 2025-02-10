package com.durand.data.repository

import app.cash.turbine.test
import com.durand.data.model.RecipeResponse
import com.durand.data.network.RecipeApi
import com.durand.domain.model.Recipe
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RecipeRepositoryImplTest {

    @Mock
    private lateinit var api: RecipeApi

    private lateinit var repository: RecipeRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this) // Inicializa los mocks
        repository = RecipeRepositoryImpl(api) // Inyectamos la API mockeada
    }

    @Test
    fun `test getRecipes emits mapped data`() = runTest {
        // Datos simulados de la API
        val mockApiResponse = listOf(
            RecipeResponse(
                nombre = "Lomo Saltado",
                descripcion = "Plato típico peruano",
                imagen = "https://example.com/lomo.jpg",
                ciudad = "Lima",
                pais = "Perú",
                latitud = -12.0464,
                longitud = -77.0428
            )
        )

        val expectedRecipes = listOf(
            Recipe(
                nombre = "Lomo Saltado",
                descripcion = "Plato típico peruano",
                imagen = "https://example.com/lomo.jpg",
                ciudad = "Lima",
                pais = "Perú",
                latitud = -12.0464,
                longitud = -77.0428
            )
        )

        // Configurar el mock de la API para devolver los datos simulados
        Mockito.`when`(api.getRecipes()).thenReturn(mockApiResponse)

        // Ejecutar la función y verificar el resultado usando Turbine
        repository.getRecipes().test {
            assertEquals(expectedRecipes, awaitItem()) // Verificamos la lista emitida
            awaitComplete() // Confirmamos que el Flow se completó correctamente
        }
    }
}
