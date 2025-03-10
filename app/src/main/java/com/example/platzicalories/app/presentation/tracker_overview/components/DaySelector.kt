package com.example.platzicalories.app.presentation.tracker_overview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme
import java.time.LocalDate

@Composable
fun DaySelector(
 date: LocalDate,
 onPreviousDayClick: () -> Unit,
 onNextDayClick: () -> Unit,
 modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onPreviousDayClick
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Previous Day"
            )
        }
        Text(
            text = ParseDateText(date  = date),
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            onClick = onNextDayClick
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Previous Day"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DaySelectorPreview() {
    PlatziCaloriesTheme {
        DaySelector(
            date = LocalDate.now(),
            onPreviousDayClick = {},
            onNextDayClick = {}
        )
    }
}