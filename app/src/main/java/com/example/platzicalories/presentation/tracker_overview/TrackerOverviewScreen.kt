package com.example.platzicalories.presentation.tracker_overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme
import com.example.platzicalories.presentation.tracker_overview.components.DaySelector
import com.example.platzicalories.presentation.tracker_overview.components.ExpandableMeal
import com.example.platzicalories.presentation.tracker_overview.components.NutrientsHeader
import com.example.platzicalories.presentation.tracker_overview.model.defaultMeals
import java.time.LocalDate

@Composable
fun TrackerOverviewScreen(
    trackerOverviewViewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader()
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
        items(defaultMeals){ meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {

                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                    ) {

                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
private fun TrackerOverviewScreenText() {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader()
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            DaySelector(
                date = LocalDate.now(),
                onPreviousDayClick = {},
                onNextDayClick = {},
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrackerOverviewScreenPreview() {
    PlatziCaloriesTheme {
        TrackerOverviewScreenText()
    }
}