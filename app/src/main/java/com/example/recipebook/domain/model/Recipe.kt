package com.example.recipebook.domain.model

data class Recipe (
    val title: String,
    val analyzedInstructions: List<AnalyzedInstruction>,
    val cookingMinutes: Int,
    val creditsText: String,
    val cuisines: List<String>,
    val diets: List<String>,
    val dishTypes: List<String>,
    val servings: Int,
    val extendedIngredients: List<ExtendedIngredient>,
    val id: Long,
    val image: String? = "",
    val imageType: String? = "",
    val instructions: String,
    val preparationMinutes: Int,
    val readyInMinutes: Long,
    val summary: String,
    val sustainable: Boolean,
    val aggregateLikes: Long? = 0,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
)

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)

data class ExtendedIngredient(
    val name: String,
    val nameClean: String? = "",
    val original: String,
    val originalName: String,
    val amount: Double,
    val unit: String,
    val measures: Measures
)

data class Step(
    val ingredients: List<Ingredient>,
    val length: Length? = null,
    val number: Int,
    val step: String
)

data class Ingredient(
    val id: Int,
    val name: String
)

data class Length(
    val number: Long,
    val unit: String
)

data class Measures(
    val metric: Metric,
    val us: Us
)

data class Metric(
    val amount: Double,
    val unitShort: String
)

data class Us(
    val amount: Double,
    val unitShort: String
)

