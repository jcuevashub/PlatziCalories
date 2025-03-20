package com.example.platzicalories.app.domain.tracker.use_case

import com.example.platzicalories.app.domain.tracker.model.MealType
import com.example.platzicalories.app.domain.tracker.model.TrackableFood
import com.example.platzicalories.app.domain.tracker.model.TrackedFood
import com.example.platzicalories.app.domain.tracker.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFoodUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g?.div(100f))?.times(amount))?.roundToInt() ?: 0,
                protein = ((food.proteinPer100g?.div(100f))?.times(amount))?.roundToInt() ?: 0,
                fat = ((food.fatPer100g?.div(100f))?.times(amount))?.roundToInt() ?: 0,
                calories = ((food.caloriesPer100g?.div(100f))?.times(amount))?.roundToInt() ?: 0,
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date,
            )
        )
    }
}