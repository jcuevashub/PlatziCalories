package com.example.platzicalories.app.presentation.onbording.gender_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzicalories.core.domain.model.Gender
import com.example.platzicalories.core.domain.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GenderViewModel() : ViewModel() {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            _uiEvent.send(UiEvent.Success)
        }
    }
}