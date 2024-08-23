package com.example.recipebook.data.remote

import com.example.recipebook.data.remote.dto.RandRecipeSet
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {

    @GET("recipes/random")
    suspend fun getRandRecipes(
        @Query("apiKey") apiKey: String,
        @Query("number") number: String
    ): RandRecipeSet

}