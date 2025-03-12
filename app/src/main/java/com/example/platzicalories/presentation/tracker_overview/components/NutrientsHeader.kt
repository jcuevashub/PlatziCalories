package com.example.platzicalories.presentation.tracker_overview.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platzicalories.R
import com.example.platzicalories.app.ui.theme.FatColor
import com.example.platzicalories.app.ui.theme.LocalSpacing
import com.example.platzicalories.app.ui.theme.PlatziCaloriesTheme
import com.example.platzicalories.app.ui.theme.ProteinColor
import com.example.platzicalories.app.ui.theme.tertiaryDark

@Composable
fun NutrientsHeader(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val animatedCalorieCount = animateIntAsState(
        targetValue = 2000
    )
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSurfaceVariant)
            .padding(
                horizontal = spacing.spaceLarge,
                vertical = spacing.spaceExtraLarge
            )
    ) {
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NutrientBarInfo(
                value = 100,
                goal = 200,
                name = stringResource(id = R.string.carbs),
                color = tertiaryDark,
                modifier = Modifier.size(90.dp)
            )
            NutrientBarInfo(
                value = 50,
                goal = 200,
                name = stringResource(id = R.string.protein),
                color = ProteinColor,
                modifier = Modifier.size(90.dp)
            )
            NutrientBarInfo(
                value = 200,
                goal = 300,
                name = stringResource(id = R.string.fat),
                color = FatColor,
                modifier = Modifier.size(90.dp)
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = animatedCalorieCount.value,
                unit = "kcal",
                amountColor = MaterialTheme.colorScheme.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colorScheme.onPrimary
            )
            Column {
                Text(
                    text = stringResource(id = R.string.your_goal),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                UnitDisplay(
                    amount = 2510,
                    unit = stringResource(id = R.string.kcal),
                    amountColor = MaterialTheme.colorScheme.onPrimary,
                    amountTextSize = 40.sp,
                    unitColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        NutrientsBar(
            carbs = 100,
            protein = 200,
            fat = 100,
            calories = 2000,
            calorieGoal = 3500,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

    }
}

@Preview (showSystemUi = true)
@Composable
private fun NutrientsHeaderPreview() {
    PlatziCaloriesTheme {
        NutrientsHeader()
    }
}