package com.example.platzicalories.presentation.search

import com.example.platzicalories.app.domain.tracker.model.MealType
import com.example.platzicalories.app.domain.tracker.model.TrackableFood
import java.time.LocalDate


sealed class SearchEvent {
    data class OnQueryChanged(val query: String) : SearchEvent()
    data object OnSearch : SearchEvent()
    data class OnToggleTrackableFood(val food: TrackableFood) : SearchEvent()
    data class OnAmountForFoodChange(
        val food: TrackableFood,
        val amount: String
    ): SearchEvent()
    data class OnTrackFoodClick(
        val food: TrackableFood,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean) : SearchEvent()
}