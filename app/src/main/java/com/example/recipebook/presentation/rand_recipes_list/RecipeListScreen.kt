package com.example.recipebook.presentation.rand_recipes_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebook.R
import com.example.recipebook.presentation.rand_recipes_list.components.RecipeListItem

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.body_margin))
        ) {
            items(state.recipes) { recipe ->
                RecipeListItem(recipe = recipe, onItemClick = {

                } )
            }
        }

        if (state.error.isNotBlank()) {
             Text(
                 text = state.error,
                 textAlign = TextAlign.Center,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(horizontal = 20.dp)
                     .align(Alignment.Center)
             )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(dimensionResource(id = R.dimen.circ_prog_indicator_lg)))
        }
    }
}