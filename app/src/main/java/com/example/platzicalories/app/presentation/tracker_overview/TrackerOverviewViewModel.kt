package com.example.platzicalories.app.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import com.example.platzicalories.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackerOverviewViewModel @Inject constructor(
    preferences: Preferences
): ViewModel() {

    init {
        preferences.saveShouldShowOnboarding(false)
    }
}