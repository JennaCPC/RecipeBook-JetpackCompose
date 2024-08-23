package com.example.recipebook.domain.repository

import com.example.recipebook.common.Resource
import com.example.recipebook.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    //was suspend
    fun getRecipes(): Flow<Resource<List<Recipe>>>

}
