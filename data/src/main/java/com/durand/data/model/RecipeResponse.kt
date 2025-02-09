package com.durand.data.model

import com.durand.domain.model.Recipe

data class RecipeResponse(
    val nombre: String,
    val descripcion: String,
    val imagen: String,
    val ciudad: String,
    val pais: String,
    val latitud: Double,
    val longitud: Double
) {
    fun toDomainModel(): Recipe {
        return Recipe(nombre, descripcion, imagen, ciudad, pais, latitud, longitud)
    }
}