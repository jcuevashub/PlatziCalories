package com.example.platzicalories.app.presentation.onbording.activity_level_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzicalories.core.domain.model.ActivityLevel
import com.example.platzicalories.core.domain.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class ActivityLevelViewModel : ViewModel() {

     var selectedActivityLevel by mutableStateOf<ActivityLevel>(
        ActivityLevel.Medium
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onActivityLevelSelect(activityLevel: ActivityLevel) {
        selectedActivityLevel = activityLevel
    }

    fun onNextClick() {
        viewModelScope.launch {
            _uiEvent.send(UiEvent.Success)
        }
    }
}