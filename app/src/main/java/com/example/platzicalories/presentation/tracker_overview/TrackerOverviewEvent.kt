package com.example.platzicalories.presentation.tracker_overview

import com.example.platzicalories.presentation.tracker_overview.model.Meal

sealed class TrackerOverviewEvent {
    data class OnToggleMealClick(val meal: Meal) : TrackerOverviewEvent()
}