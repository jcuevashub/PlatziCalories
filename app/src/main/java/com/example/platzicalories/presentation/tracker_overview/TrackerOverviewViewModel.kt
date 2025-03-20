package com.example.platzicalories.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzicalories.app.domain.tracker.use_case.TrackerUseCases
import com.example.platzicalories.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerOverviewViewModel @Inject constructor(
    preferences: Preferences,
    private val trackerUseCases: TrackerUseCases
): ViewModel() {

    init {
        preferences.saveShouldShowOnboarding(false)
    }

    private fun executeSearch() {
        viewModelScope.launch {
            trackerUseCases.searchFoodUseCase("egg")
        }
    }
}