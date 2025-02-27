package com.example.platzicalories.app.presentation.onbording.nutrient_screen

sealed class NutrientGoalEvent {
    data class OnCarbRatioEnter(val ratio: String): NutrientGoalEvent()
    data class OnProteinRatioEnter(val ratio: String): NutrientGoalEvent()
    data class OnFatRatioEnter(val ratio: String): NutrientGoalEvent()
    data object OnNextClick: NutrientGoalEvent()
}