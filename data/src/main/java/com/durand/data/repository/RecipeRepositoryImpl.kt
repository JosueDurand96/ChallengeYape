package com.durand.data.repository

import com.durand.data.network.RecipeApi
import com.durand.domain.model.Recipe
import com.durand.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {
    override fun getRecipes(): Flow<List<Recipe>> = flow {
        val response = api.getRecipes()
        emit(response.map { it.toDomainModel() })
    }
}