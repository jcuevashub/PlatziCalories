package com.example.platzicalories.app.domain.tracker.model

sealed class MealType(val name: String) {
    data object Breakfast: MealType("breakfast")
    data object Lunch: MealType("lunch")
    data object Dinner: MealType("dinner")
    data object Snack: MealType("snack")

    companion object {
        fun fromString(name: String): MealType {
            return when (name.lowercase()) {
                "breakfast" -> Breakfast
                "lunch" -> Lunch
                "dinner" -> Dinner
                "snack" -> Snack
                else -> Breakfast
            }
        }
    }
}