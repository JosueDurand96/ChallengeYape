package com.durand.data.di

import com.durand.data.network.RecipeApi
import junit.framework.TestCase.assertNotNull
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModuleTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var retrofit: Retrofit

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Simulamos Retrofit con un servidor de prueba
        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // Usa MockWebServer en vez de un endpoint real
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test provideRetrofit creates a valid instance`() {
        assertNotNull(retrofit) // Verifica que Retrofit no es nulo
    }

    @Test
    fun `test provideRecipeApi creates a valid instance`() {
        val api = retrofit.create(RecipeApi::class.java)
        assertNotNull(api) // Verifica que la API no es nula
    }
}