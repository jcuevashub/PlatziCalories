package com.example.platzicalories.app.presentation.onbording.goal_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzicalories.core.domain.model.GoalType
import com.example.platzicalories.core.domain.preferences.Preferences
import com.example.platzicalories.core.domain.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var selectedGoal by mutableStateOf<GoalType>(
        GoalType.KeepWeight
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalTypeSelect(goalType: GoalType) {
        selectedGoal = goalType
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGoalType(selectedGoal)
            _uiEvent.send(UiEvent.Success)
        }
    }
}