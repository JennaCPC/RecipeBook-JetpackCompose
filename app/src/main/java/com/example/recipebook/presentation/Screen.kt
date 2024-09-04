package com.example.recipebook.presentation

sealed class Screen(val route: String) {

    object MyRecipesScreen : Screen ("my_recipes")
    object RecipeListScreen : Screen ("recipes")
    object RecipeDetailsScreen : Screen ("recipe_details")
    object AddRecipeScreen : Screen ("add_recipe")
}