package com.example.recipebook.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem(
        label = "My Recipes",
        icon = Icons.Filled.RestaurantMenu,
        route = Screen.MyRecipesScreen.route
    ),
    BottomNavItem(
        label = "Find Recipes",
        icon = Icons.Filled.Search,
        route = Screen.RecipeListScreen.route
    )
)