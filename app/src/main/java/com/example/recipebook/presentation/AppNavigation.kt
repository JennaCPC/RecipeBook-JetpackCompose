package com.example.recipebook.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipebook.presentation.add_recipe.AddRecipeScreen
import com.example.recipebook.presentation.my_recipes_list.MyRecipesScreen
import com.example.recipebook.presentation.rand_recipes_list.RecipeListScreen
import com.example.recipebook.presentation.recipe_details.RecipeDetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavRoutes = setOf(
        Screen.MyRecipesScreen.route,
        Screen.RecipeDetailsScreen.route,
        Screen.RecipeListScreen.route
    )

    Scaffold(
        floatingActionButton = {
            Box() {
                if (currentRoute in bottomNavRoutes) {
                    FloatingActionButton(
                        onClick = {
                            Screen.AddRecipeScreen.route?.let {
                                navController.navigate(it)
                            }
                        },
                        shape = CircleShape,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(55.dp)
                            .offset(y = 50.dp),
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (currentRoute in bottomNavRoutes) {
                NavigationBar(
                    //containerColor = MaterialTheme.colorScheme.primaryContainer
                    modifier = Modifier.height(65.dp)
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    bottomNavItems.forEach() { navItem ->
                        val selected =
                            currentDestination?.hierarchy?.any { it.route == navItem.route }
                        NavigationBarItem(
                            selected = selected == true,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            label = {
                                Text(
                                    text = navItem.label,
                                    color = if (selected == true) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = navItem.label,
                                    tint = if (selected == true) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }

        }
    )
    {
        NavHost(
            navController = navController,
            startDestination = Screen.MyRecipesScreen.route,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Screen.MyRecipesScreen.route) {
                MyRecipesScreen(navController)
            }
            composable(route = Screen.RecipeListScreen.route) {
                RecipeListScreen(navController = navController)
            }
            composable(route = Screen.RecipeDetailsScreen.route) {
                RecipeDetailsScreen(navController)
            }
            composable(route = Screen.AddRecipeScreen.route) {
                AddRecipeScreen(navController)
            }

        }
    }
}