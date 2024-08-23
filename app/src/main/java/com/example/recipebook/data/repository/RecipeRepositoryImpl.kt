package com.example.recipebook.data.repository

import com.example.recipebook.common.Constants
import com.example.recipebook.common.Resource
import com.example.recipebook.data.mapper.toRecipe
import com.example.recipebook.data.remote.SpoonacularApi
import com.example.recipebook.domain.model.Recipe
import com.example.recipebook.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class RecipeRepositoryImpl(
    private val api: SpoonacularApi
) : RecipeRepository {

    override fun getRecipes(): Flow<Resource<List<Recipe>>> = flow {
        try {
            emit(Resource.Loading())
            val recipes = api.getRandRecipes(Constants.API_KEY, "10").recipes.map { it.toRecipe()}
            emit(Resource.Success(recipes))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {          //connection to remote api
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }
}