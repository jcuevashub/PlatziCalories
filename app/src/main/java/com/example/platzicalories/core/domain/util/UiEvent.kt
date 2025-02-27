package com.example.platzicalories.core.domain.util

sealed class UiEvent {
    data object Success: UiEvent()
    data object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}