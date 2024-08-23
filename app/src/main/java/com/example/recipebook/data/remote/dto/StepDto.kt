package com.example.recipebook.data.remote.dto

data class StepDto(
    val equipment: List<EquipmentDto>,
    val ingredients: List<IngredientDto>,
    val length: LengthDto? = null,
    val number: Int,
    val step: String
)