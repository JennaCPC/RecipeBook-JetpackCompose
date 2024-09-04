package com.example.recipebook.presentation.add_recipe

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun AddRecipeScreen(navController: NavHostController) {
    Box() {
        IconButton(onClick = {
            navController.navigateUp()
        }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back")
        }
    }

}