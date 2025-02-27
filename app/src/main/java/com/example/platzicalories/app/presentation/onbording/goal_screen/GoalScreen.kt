package com.example.platzicalories.app.presentation.onbording.goal_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.platzicalories.R
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme
import com.example.platzicalories.app.presentation.onbording.components.ActionButton
import com.example.platzicalories.app.presentation.onbording.components.SelectableButton
import com.example.platzicalories.core.domain.model.GoalType
import com.example.platzicalories.core.domain.util.UiEvent

@Composable
fun GoalScreen(
    onNextClick: () -> Unit,
    goalViewModel: GoalViewModel = viewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        goalViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.lose),
                    isSelected = goalViewModel.selectedGoal is GoalType.LoseWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        goalViewModel.onGoalTypeSelect(GoalType.LoseWeight)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.keep),
                    isSelected = goalViewModel.selectedGoal is GoalType.KeepWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        goalViewModel.onGoalTypeSelect(GoalType.KeepWeight)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.gain),
                    isSelected = goalViewModel.selectedGoal is GoalType.GainWeight,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        goalViewModel.onGoalTypeSelect(GoalType.GainWeight)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClick() },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

//@Preview
//@Composable
//private fun GoalScreenPreview() {
//    PlatziCaloriesTheme {
//        GoalScreen {
//
//        }
//    }
//}
