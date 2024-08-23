package com.example.recipebook.domain.use_case.get_recipes

import com.example.recipebook.common.Resource
import com.example.recipebook.domain.model.Recipe
import com.example.recipebook.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
){
    operator fun invoke(): Flow<Resource<List<Recipe>>> {
        return repository.getRecipes()
    }
}