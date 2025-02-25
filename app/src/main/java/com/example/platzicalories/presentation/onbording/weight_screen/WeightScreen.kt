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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.platzicalories.R
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme
import com.example.platzicalories.presentation.onbording.components.ActionButton
import com.example.platzicalories.presentation.onbording.components.UnitTextField

@Composable
fun WeightScreen(
    onNextClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

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
                onValueChange = {},
                unit = stringResource(id = R.string.kg)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {onNextClick()},
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WeightScreenPreview() {
    PlatziCaloriesTheme {
        WeightScreen { }
    }
}