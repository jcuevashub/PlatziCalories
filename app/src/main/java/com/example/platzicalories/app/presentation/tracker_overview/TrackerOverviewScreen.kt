package com.example.platzicalories.app.presentation.tracker_overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme

@Composable
fun TrackerOverviewScreen(
    trackerOverviewViewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tracker Overview Screen"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrackerOverviewScreenPreview() {
    PlatziCaloriesTheme {
        TrackerOverviewScreen()
    }
}