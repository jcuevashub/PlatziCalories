package com.example.platzicalories.presentation.onbording.weight_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.platzicalories.R
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.core.domain.util.UiEvent
import com.example.platzicalories.presentation.onbording.components.ActionButton
import com.example.platzicalories.presentation.onbording.components.UnitTextField

@Composable
fun WeightScreen(
    snackbarState: SnackbarHostState,
    onNextClick: () -> Unit,
    weightViewModel: WeightViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        weightViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                is UiEvent.ShowSnackbar -> {
                    snackbarState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

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
                text = stringResource(id = R.string.whats_your_weight),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = "180",
                onValueChange = weightViewModel::onWeightEnter,
                unit = stringResource(id = R.string.kg)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = weightViewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
//
//@Preview(showBackground = true)
//@Composable
//private fun WeightScreenPreview() {
//    PlatziCaloriesTheme {
//        WeightScreen { }
//    }
//}