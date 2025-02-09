package com.durand.domain.usecase

import com.durand.domain.model.Recipe
import com.durand.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    fun execute(): Flow<List<Recipe>> = repository.getRecipes()
}
