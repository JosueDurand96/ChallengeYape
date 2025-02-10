package com.durand.data.network

import com.durand.data.model.RecipeResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: RecipeApi

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // URL falsa del MockWebServer
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RecipeApi::class.java)
    }

    @Test
    fun `test getRecipes returns expected list`() = runBlocking {
        // JSON simulado para la respuesta de la API
        val mockJson = """
            [
                {
                    "nombre": "Lomo Saltado",
                    "descripcion": "Plato típico peruano",
                    "imagen": "https://example.com/lomo.jpg",
                    "ciudad": "Lima",
                    "pais": "Perú",
                    "latitud": -12.0464,
                    "longitud": -77.0428
                }
            ]
        """.trimIndent()

        // Configurar la respuesta del MockWebServer
        mockWebServer.enqueue(
            MockResponse()
                .setBody(mockJson)
                .setResponseCode(200)
        )

        // Llamar al método getRecipes()
        val recipes: List<RecipeResponse> = api.getRecipes()

        // Verificar que los datos sean correctos
        assertEquals(1, recipes.size)
        assertEquals("Lomo Saltado", recipes[0].nombre)
        assertEquals("Plato típico peruano", recipes[0].descripcion)
        assertEquals("https://example.com/lomo.jpg", recipes[0].imagen)
        assertEquals("Lima", recipes[0].ciudad)
        assertEquals("Perú", recipes[0].pais)
        assertEquals(-12.0464, recipes[0].latitud, 0.0001)
        assertEquals(-77.0428, recipes[0].longitud, 0.0001)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
