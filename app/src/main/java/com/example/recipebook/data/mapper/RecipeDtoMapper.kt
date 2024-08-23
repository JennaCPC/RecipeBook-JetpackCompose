package com.example.recipebook.data.mapper

import com.example.recipebook.data.remote.dto.AnalyzedInstructionDto
import com.example.recipebook.data.remote.dto.ExtendedIngredientDto
import com.example.recipebook.data.remote.dto.IngredientDto
import com.example.recipebook.data.remote.dto.LengthDto
import com.example.recipebook.data.remote.dto.MeasuresDto
import com.example.recipebook.data.remote.dto.MetricDto
import com.example.recipebook.data.remote.dto.RecipeDto
import com.example.recipebook.data.remote.dto.StepDto
import com.example.recipebook.data.remote.dto.UsDto
import com.example.recipebook.domain.model.AnalyzedInstruction
import com.example.recipebook.domain.model.ExtendedIngredient
import com.example.recipebook.domain.model.Ingredient
import com.example.recipebook.domain.model.Length
import com.example.recipebook.domain.model.Measures
import com.example.recipebook.domain.model.Metric
import com.example.recipebook.domain.model.Recipe
import com.example.recipebook.domain.model.Step
import com.example.recipebook.domain.model.Us

fun RecipeDto.toRecipe(): Recipe {
    return Recipe(
        title = title,
        analyzedInstructions = analyzedInstructions.map { it.toAnalyzedInstruction() },
        cookingMinutes=cookingMinutes,
        creditsText=creditsText,
        cuisines=cuisines,
        dairyFree=dairyFree,
        diets=diets,
        dishTypes=dishTypes,
        extendedIngredients=extendedIngredients.map { it.toExtendedIngredients() },
        glutenFree=glutenFree,
        id=id,
        image=image,
        imageType=imageType,
        instructions=instructions,
        preparationMinutes=preparationMinutes,
        readyInMinutes=readyInMinutes,
        servings=servings,
        summary=summary,
        sustainable=sustainable,
        vegan=vegan,
        vegetarian=vegetarian,
        veryHealthy=veryHealthy,
        veryPopular=veryPopular,
    )
}

fun AnalyzedInstructionDto.toAnalyzedInstruction(): AnalyzedInstruction {
    return AnalyzedInstruction(
        name = name,
        steps = steps.map { it.toStep() }
    )
}

fun ExtendedIngredientDto.toExtendedIngredients(): ExtendedIngredient {
    return ExtendedIngredient(
        name = name,
        nameClean = nameClean,
        original = original,
        originalName = originalName,
        amount = amount,
        unit = unit,
        measures = measures.toMeasure()
    )
}

fun StepDto.toStep(): Step {
    return Step(
        ingredients = ingredients.map { it.toIngredient() },
        length = length?.toLength(),
        number = number,
        step = step
    )
}

fun IngredientDto.toIngredient(): Ingredient {
    return Ingredient(
        id = id,
        name = name
    )
}

fun LengthDto.toLength(): Length {
    return Length(
        number = number,
        unit = unit
    )
}

fun MeasuresDto.toMeasure(): Measures {
    return Measures(
        metric = metric.toMetric(),
        us = us.toUs()
    )
}

fun MetricDto.toMetric(): Metric {
    return Metric(
        amount = amount,
        unitShort = unitShort
    )
}

fun UsDto.toUs(): Us {
    return Us(
        amount = amount,
        unitShort = unitShort
    )
}



