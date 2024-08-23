package com.example.recipebook.presentation.rand_recipes_list

import com.example.recipebook.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    val error: String = ""
)
