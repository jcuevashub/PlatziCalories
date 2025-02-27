package com.example.platzicalories.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.platzicalories.app.presentation.onbording.activity_level_screen.ActivityLevelScreen
import com.example.platzicalories.app.presentation.onbording.activity_level_screen.ActivityLevelViewModel
import com.example.platzicalories.app.presentation.onbording.age_screen.AgeScreen
import com.example.platzicalories.app.presentation.onbording.age_screen.AgeViewModel
import com.example.platzicalories.app.presentation.onbording.gender_screen.GenderScreen
import com.example.platzicalories.app.presentation.onbording.gender_screen.GenderViewModel
import com.example.platzicalories.app.presentation.onbording.goal_screen.GoalScreen
import com.example.platzicalories.app.presentation.onbording.goal_screen.GoalViewModel
import com.example.platzicalories.app.presentation.onbording.height_screen.HeightScreen
import com.example.platzicalories.app.presentation.onbording.height_screen.HeightViewModel
import com.example.platzicalories.app.presentation.onbording.nutrient_screen.NutrientGoalScreen
import com.example.platzicalories.app.presentation.onbording.nutrient_screen.NutrientGoalViewModel
import com.example.platzicalories.app.presentation.onbording.weight_screen.WeightScreen
import com.example.platzicalories.app.presentation.onbording.weight_screen.WeightViewModel
import com.example.platzicalories.app.presentation.onbording.welcome_screen.WelcomeScreen
import com.example.platzicalories.app.presentation.tracker_overview.TrackerOverviewScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController,
    snackbarHostState: SnackbarHostState
) {
    val genderViewModel = GenderViewModel()
    val ageViewModel = AgeViewModel()
    val heightViewModel = HeightViewModel()
    val weightViewModel = WeightViewModel()
    val activityLevelViewModel = ActivityLevelViewModel()
    val goalViewModel = GoalViewModel()
    val nutrientGoalViewModel = NutrientGoalViewModel()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = WelcomeScreenRoute
        ) {
            composable<WelcomeScreenRoute>() {
                WelcomeScreen {
                    navHostController.navigate(GenderScreenRoute)
                }
            }
            composable<GenderScreenRoute> {
                GenderScreen(
                    onNextClick = {
                        navHostController.navigate(AgeScreenRoute)
                    },
                    genderViewModel = genderViewModel
                )

            }
            composable<AgeScreenRoute> {
                AgeScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(HeightScreenRoute)
                    },
                    ageViewModel = ageViewModel
                )
            }
            composable<HeightScreenRoute> {
                HeightScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(ActivityLevelScreenRoute)
                    },
                    heightViewModel = heightViewModel
                )
            }
            composable<WeightScreenRoute> {
                WeightScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(ActivityLevelScreenRoute)
                    },
                    weightViewModel = weightViewModel
                )
            }
            composable<ActivityLevelScreenRoute> {
                ActivityLevelScreen(
                    onNextClick = {
                        navHostController.navigate(GoalScreenRoute)
                    },
                    activityLevelViewModel = activityLevelViewModel
                )
            }
            composable<GoalScreenRoute> {
                GoalScreen(
                    onNextClick = {
                        navHostController.navigate(NutrientGoalScreenRoute)
                    },
                    goalViewModel = goalViewModel
                )
            }
            composable<NutrientGoalScreenRoute> {
                NutrientGoalScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(TrackerOverviewScreenRoute)
                    },
                    nutrientGoalViewModel = nutrientGoalViewModel
                )
            }
            composable<TrackerOverviewScreenRoute> {
                TrackerOverviewScreen()
            }
        }
    }
}