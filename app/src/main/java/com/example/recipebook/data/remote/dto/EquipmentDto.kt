package com.example.recipebook.data.remote.dto

data class EquipmentDto(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String,
    val temperature: TemperatureDto
)