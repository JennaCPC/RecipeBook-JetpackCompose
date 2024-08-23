package com.example.recipebook.presentation.rand_recipes_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebook.common.Resource
import com.example.recipebook.domain.use_case.get_recipes.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
   private val getRecipesUseCase : GetRecipesUseCase
) : ViewModel() {

    // private set
    private val _state = mutableStateOf(RecipeListState())
    val state: State<RecipeListState> = _state

    init {
        getRecipes()
    }

    private fun getRecipes() {
        getRecipesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RecipeListState(recipes = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = RecipeListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = RecipeListState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }
}