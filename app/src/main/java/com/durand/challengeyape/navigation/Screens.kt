package com.durand.challengeyape.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
object FirstModal

@Serializable
data class PersonalData(
    val info: PersonalDataInfo,
)

@Serializable
@Parcelize
data class PersonalDataInfo(
    val nombre: String,
    val descripcion: String,
    val imagen: String,
    val ciudad: String,
    val pais: String,
    val latitud: String,
    val longitud: String,
) : Parcelable

@Serializable
data class MapData(
    val info: MapDataInfo,
)

@Serializable
@Parcelize
data class MapDataInfo(
    val nombre: String,
    val descripcion: String,
    val imagen: String,
    val ciudad: String,
    val pais: String,
    val latitud: String,
    val longitud: String,
) : Parcelable