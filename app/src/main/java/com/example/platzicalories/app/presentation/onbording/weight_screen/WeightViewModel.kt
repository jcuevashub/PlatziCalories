package com.example.platzicalories.app.presentation.onbording.weight_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzicalories.R
import com.example.platzicalories.core.domain.util.UiEvent
import com.example.platzicalories.core.domain.util.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class WeightViewModel: ViewModel() {

    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String) {
        if(weight.length <= 5) {
            this.weight = weight
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val weightNumber = weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.error_weight_cant_be_empty)
                    )
                )
                return@launch
            }
            _uiEvent.send(UiEvent.Success)
        }
    }
}