package com.durand.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class RecipeTest {

    @Test
    fun `Recipe should be created correctly`() {
        val recipe = Recipe(
            nombre = "Pasta Carbonara",
            descripcion = "Una receta italiana clásica",
            imagen = "https://example.com/image.jpg",
            ciudad = "Roma",
            pais = "Italia",
            latitud = 41.9028,
            longitud = 12.4964
        )

        assertEquals("Pasta Carbonara", recipe.nombre)
        assertEquals("Una receta italiana clásica", recipe.descripcion)
        assertEquals("https://example.com/image.jpg", recipe.imagen)
        assertEquals("Roma", recipe.ciudad)
        assertEquals("Italia", recipe.pais)
        assertEquals(41.9028, recipe.latitud, 0.0001)
        assertEquals(12.4964, recipe.longitud, 0.0001)
    }

    @Test
    fun `Recipes with same data should be equal`() {
        val recipe1 = Recipe(
            nombre = "Tacos",
            descripcion = "Tacos mexicanos tradicionales",
            imagen = "https://example.com/tacos.jpg",
            ciudad = "Ciudad de México",
            pais = "México",
            latitud = 19.4326,
            longitud = -99.1332
        )

        val recipe2 = Recipe(
            nombre = "Tacos",
            descripcion = "Tacos mexicanos tradicionales",
            imagen = "https://example.com/tacos.jpg",
            ciudad = "Ciudad de México",
            pais = "México",
            latitud = 19.4326,
            longitud = -99.1332
        )

        assertEquals(recipe1, recipe2) // Deben ser iguales
    }

    @Test
    fun `Recipes with different data should not be equal`() {
        val recipe1 = Recipe(
            nombre = "Hamburguesa",
            descripcion = "Hamburguesa casera con queso",
            imagen = "https://example.com/burger.jpg",
            ciudad = "New York",
            pais = "USA",
            latitud = 40.7128,
            longitud = -74.0060
        )

        val recipe2 = Recipe(
            nombre = "Pizza",
            descripcion = "Pizza napolitana auténtica",
            imagen = "https://example.com/pizza.jpg",
            ciudad = "Nápoles",
            pais = "Italia",
            latitud = 40.8518,
            longitud = 14.2681
        )

        assertNotEquals(recipe1, recipe2) // No deben ser iguales
    }

    @Test
    fun `copy function should create a new object with modified values`() {
        val recipe1 = Recipe(
            nombre = "Sushi",
            descripcion = "Sushi tradicional japonés",
            imagen = "https://example.com/sushi.jpg",
            ciudad = "Tokio",
            pais = "Japón",
            latitud = 35.6895,
            longitud = 139.6917
        )

        val recipe2 = recipe1.copy(nombre = "Ramen") // Solo cambiamos el nombre

        assertNotEquals(recipe1, recipe2) // Son diferentes
        assertEquals("Ramen", recipe2.nombre) // El nuevo nombre es "Ramen"
        assertEquals(recipe1.descripcion, recipe2.descripcion) // El resto sigue igual
        assertEquals(recipe1.imagen, recipe2.imagen)
        assertEquals(recipe1.ciudad, recipe2.ciudad)
        assertEquals(recipe1.pais, recipe2.pais)
        assertEquals(recipe1.latitud, recipe2.latitud, 0.0001)
        assertEquals(recipe1.longitud, recipe2.longitud, 0.0001)
    }
}