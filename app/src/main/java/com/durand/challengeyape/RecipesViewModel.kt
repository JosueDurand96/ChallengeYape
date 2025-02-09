package com.durand.challengeyape

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

// ViewModel
class RecipesViewModel : ViewModel() {
    val recipes = liveData {
        emit(
            listOf(
                Recipe(1, "Pizza Margherita", R.drawable.pizza, "Tomato, Mozzarella, Basil", "Italy"),
                Recipe(2, "Sushi", R.drawable.pizza, "Rice, Fish, Seaweed", "Japan")
            )
        )
    }
}
