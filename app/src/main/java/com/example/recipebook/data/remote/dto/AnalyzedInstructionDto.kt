package com.example.recipebook.data.remote.dto

data class AnalyzedInstructionDto(
    val name: String,
    val steps: List<StepDto>
)