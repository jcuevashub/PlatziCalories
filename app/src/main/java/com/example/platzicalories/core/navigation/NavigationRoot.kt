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
import com.example.platzicalories.app.presentation.onbording.age_screen.AgeScreen
import com.example.platzicalories.app.presentation.onbording.gender_screen.GenderScreen
import com.example.platzicalories.app.presentation.onbording.goal_screen.GoalScreen
import com.example.platzicalories.app.presentation.onbording.height_screen.HeightScreen
import com.example.platzicalories.app.presentation.onbording.nutrient_screen.NutrientGoalScreen
import com.example.platzicalories.app.presentation.onbording.weight_screen.WeightScreen
import com.example.platzicalories.app.presentation.onbording.welcome_screen.WelcomeScreen
import com.example.platzicalories.app.presentation.tracker_overview.TrackerOverviewScreen

@Composable
fun NavigationRoot(
    shouldShowOnBoarding: Boolean,
    navHostController: NavHostController,
    snackbarHostState: SnackbarHostState
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = if(shouldShowOnBoarding) {
                WelcomeScreenRoute
            } else {
                TrackerOverviewScreenRoute
            }
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
                    }
                )

            }
            composable<AgeScreenRoute> {
                AgeScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(HeightScreenRoute)
                    }
                )
            }
            composable<HeightScreenRoute> {
                HeightScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(ActivityLevelScreenRoute)
                    }
                )
            }
            composable<WeightScreenRoute> {
                WeightScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(ActivityLevelScreenRoute)
                    }
                )
            }
            composable<ActivityLevelScreenRoute> {
                ActivityLevelScreen(
                    onNextClick = {
                        navHostController.navigate(GoalScreenRoute)
                    }
                )
            }
            composable<GoalScreenRoute> {
                GoalScreen(
                    onNextClick = {
                        navHostController.navigate(NutrientGoalScreenRoute)
                    }
                )
            }
            composable<NutrientGoalScreenRoute> {
                NutrientGoalScreen(
                    snackbarState = snackbarHostState,
                    onNextClick = {
                        navHostController.navigate(TrackerOverviewScreenRoute)
                    }
                )
            }
            composable<TrackerOverviewScreenRoute> {
                TrackerOverviewScreen()
            }
        }
    }
}