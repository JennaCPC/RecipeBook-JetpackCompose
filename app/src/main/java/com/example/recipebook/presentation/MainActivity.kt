package com.example.recipebook.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.recipebook.presentation.rand_recipes_list.RecipeListScreen
import com.example.recipebook.presentation.ui.theme.RecipeBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeBookTheme {
                RecipeListScreen()
            }
        }
    }
}
