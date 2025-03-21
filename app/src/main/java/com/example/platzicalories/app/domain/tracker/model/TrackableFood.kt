package com.example.platzicalories.app.domain.tracker.model

data class TrackableFood(
    val name: String,
    val imageUrl: String?,
    val caloriesPer100g: Int?,
    val carbsPer100g: Int?,
    val proteinPer100g: Int?,
    val fatPer100g: Int?
)
