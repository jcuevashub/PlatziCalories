package com.example.platzicalories.presentation.search

import com.example.platzicalories.presentation.search.model.TrackableFoodUiState

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)