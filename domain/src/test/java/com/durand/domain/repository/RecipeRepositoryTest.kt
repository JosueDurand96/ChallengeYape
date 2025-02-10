package com.durand.domain.repository

import app.cash.turbine.test
import com.durand.data.model.RecipeResponse
import com.durand.data.network.RecipeApi
import com.durand.data.repository.RecipeRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class RecipeRepositoryTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var api: RecipeApi

    private lateinit var repository: RecipeRepositoryImpl

    @Before
    fun setup() {
        repository = RecipeRepositoryImpl(api)
    }

    @Test
    fun `getRecipes should return list of recipes`() = runTest {
        // Simulamos la respuesta de la API con datos de prueba
        val mockApiResponse = listOf(
            RecipeResponse(
                nombre = "Pasta Carbonara",
                descripcion = "Receta clásica italiana",
                imagen = "https://example.com/pasta.jpg",
                ciudad = "Roma",
                pais = "Italia",
                latitud = 41.9028,
                longitud = 12.4964
            ),
            RecipeResponse(
                nombre = "Tacos",
                descripcion = "Tacos tradicionales",
                imagen = "https://example.com/tacos.jpg",
                ciudad = "Ciudad de México",
                pais = "México",
                latitud = 19.4326,
                longitud = -99.1332
            )
        )

        // Convertimos los datos esperados a dominio
        val expectedRecipes = mockApiResponse.map { it.toDomainModel() }

        // Configuramos el mock de la API para devolver los datos simulados
        `when`(api.getRecipes()).thenReturn(mockApiResponse)

        // Probamos el flujo usando Turbine
        repository.getRecipes().test {
            assertEquals(expectedRecipes, awaitItem()) // Verificamos la lista emitida
            awaitComplete() // Confirmamos que el Flow se completó correctamente
        }
    }
}
