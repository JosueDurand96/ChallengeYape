package com.durand.data.network

import com.durand.data.model.RecipeResponse
import retrofit2.http.GET

interface RecipeApi {

    @GET("v1/a6876d70-a9b5-4328-8513-ee10d390f6a7")
    suspend fun getRecipes(): List<RecipeResponse>
}