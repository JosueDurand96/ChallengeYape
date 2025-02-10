package com.durand.data.model

import com.durand.domain.model.Recipe
import org.junit.Assert.assertEquals
import org.junit.Test

class RecipeResponseTest {

    @Test
    fun `test toDomainModel converts correctly`() {
        // Datos de prueba
        val recipeResponse = RecipeResponse(
            nombre = "Lomo Saltado",
            descripcion = "Plato típico peruano",
            imagen = "https://example.com/lomo.jpg",
            ciudad = "Lima",
            pais = "Perú",
            latitud = -12.0464,
            longitud = -77.0428
        )

        // Conversión a modelo de dominio
        val domainRecipe: Recipe = recipeResponse.toDomainModel()

        // Verificación de los datos convertidos
        assertEquals(recipeResponse.nombre, domainRecipe.nombre)
        assertEquals(recipeResponse.descripcion, domainRecipe.descripcion)
        assertEquals(recipeResponse.imagen, domainRecipe.imagen)
        assertEquals(recipeResponse.ciudad, domainRecipe.ciudad)
        assertEquals(recipeResponse.pais, domainRecipe.pais)
        assertEquals(recipeResponse.latitud, domainRecipe.latitud, 0.0001)
        assertEquals(recipeResponse.longitud, domainRecipe.longitud, 0.0001)
    }
}
