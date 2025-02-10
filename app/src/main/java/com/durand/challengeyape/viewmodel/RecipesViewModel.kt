package com.durand.challengeyape.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.domain.model.Recipe
import com.durand.domain.usecase.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Recipe>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Recipe>>> = _uiState

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            getRecipesUseCase.execute()
                .onStart { _uiState.value = UiState.Loading }
                .catch { e -> _uiState.value = UiState.Error(e.message ?: "Error desconocido") }
                .collect { recipesList -> _uiState.value = UiState.Success(recipesList) }
        }
    }
}