package com.example.recipebook.di

import com.example.recipebook.common.Constants
import com.example.recipebook.data.remote.SpoonacularApi
import com.example.recipebook.data.repository.RecipeRepositoryImpl
import com.example.recipebook.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSpoonacularApi(): SpoonacularApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpoonacularApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(api: SpoonacularApi): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

}