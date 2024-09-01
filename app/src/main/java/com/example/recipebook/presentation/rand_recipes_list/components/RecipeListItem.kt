package com.example.recipebook.presentation.rand_recipes_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.recipebook.R
import com.example.recipebook.domain.model.Recipe
import com.example.recipebook.presentation.IconWithTextSmall
import com.example.recipebook.presentation.ui.theme.dairyFree
import com.example.recipebook.presentation.ui.theme.glutenFree
import com.example.recipebook.presentation.ui.theme.vegan
import com.example.recipebook.presentation.ui.theme.vegetarian

@Composable
fun RecipeListItem(
    recipe: Recipe,
    onItemClick: (Recipe) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(recipe) }
            .height(IntrinsicSize.Min),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        ),
    ) {
        val model = ImageRequest
            .Builder(LocalContext.current)
            .data(recipe.image)
            .size(Size.ORIGINAL)
            .build()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(-10.dp)
        ) {
            // Image background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.70f),
                contentAlignment = Alignment.Center
            ) {
                when (val imageState = rememberAsyncImagePainter(model = model).state) {
                    is AsyncImagePainter.State.Success -> {
                        Image(
                            painter = imageState.painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    is AsyncImagePainter.State.Loading -> CircularProgressIndicator(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.circ_prog_indicator_lg)),
                        color = MaterialTheme.colorScheme.primary
                    )
                    else -> Icon(
                        modifier = Modifier
                            .size(60.dp),
                        imageVector = Icons.Rounded.ImageNotSupported,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

            }
            Box(
                modifier = Modifier
                    .weight(0.30f)
                    .clip(RoundedCornerShape(6.dp))
                    .fillMaxWidth()
                    .align(Alignment.End)
                    .background(MaterialTheme.colorScheme.surfaceContainerLow)
                    .padding(10.dp)
                ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    var infoTag = true

                    Row {
                        when {
                            recipe.vegan -> InfoTag("Vegan", color = vegan)
                            recipe.vegetarian -> InfoTag("Vegetarian", color = vegetarian)
                            recipe.dairyFree -> InfoTag("Dairy Free", color = dairyFree)
                            recipe.glutenFree -> InfoTag("Gluten Free", color = glutenFree)
                            else -> infoTag = false
                        }
                    }
                    Text(
                        text = "${recipe.title}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Adjust height of column to keep image height consistent
                    if (!infoTag) {
                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        IconWithTextSmall(
                            icon = Icons.Outlined.AccessTime,
                            contentDesc = "time",
                            text = "${recipe.readyInMinutes} mins",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        IconWithTextSmall(
                            icon = Icons.Outlined.Group,
                            contentDesc = "servings",
                            text = "${recipe.servings}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        IconWithTextSmall(
                            icon = Icons.Outlined.FavoriteBorder,
                            contentDesc = "likes",
                            text = "${recipe.aggregateLikes}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                    }
                }
            }
        }
    }
}
