package com.example.platzicalories.app.data.remote.mapper
import com.example.platzicalories.app.data.remote.dto.Product
import com.example.platzicalories.app.domain.tracker.model.TrackableFood
import kotlin.math.roundToInt


fun Product.toTrackableFood(): TrackableFood? {
    val carbsPer100g = nutriments.carbohydrates100g?.roundToInt()
    val proteinPer100g = nutriments.proteins100g?.roundToInt()
    val fatPer100g = nutriments.proteins100g?.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g?.roundToInt()
    return TrackableFood(
        name = productName ?: return null,
        carbsPer100g = carbsPer100g,
        proteinPer100g = proteinPer100g,
        fatPer100g = fatPer100g,
        caloriesPer100g = caloriesPer100g,
        imageUrl = imageFrontThumbUrl
    )
}