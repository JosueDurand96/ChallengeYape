package com.durand.domain.model

// Data Model
data class Recipe(
    val nombre: String,
    val descripcion: String,
    val imagen: String,
    val ciudad: String,
    val pais: String,
    val latitud: Double,
    val longitud: Double,
)
