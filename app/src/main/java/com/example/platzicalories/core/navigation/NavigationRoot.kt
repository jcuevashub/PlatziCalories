package com.example.platzicalories.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.platzicalories.presentation.onbording.activity_level_screen.ActivityLevelScreen
import com.example.platzicalories.presentation.onbording.age_screen.AgeScreen
import com.example.platzicalories.presentation.onbording.gender_screen.GenderScreen
import com.example.platzicalories.presentation.onbording.goal_screen.GoalScreen
import com.example.platzicalories.presentation.onbording.height_screen.HeightScreen
import com.example.platzicalories.presentation.onbording.nutrient_screen.NutrientGoalScreen
import com.example.platzicalories.presentation.onbording.weight_screen.WeightScreen
import com.example.platzicalories.presentation.onbording.welcome_screen.WelcomeScreen
import com.example.platzicalories.presentation.tracker_overview.TrackerOverviewScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController
) {
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
                GenderScreen {
                    navHostController.navigate(AgeScreenRoute)
                }
            }
            composable<AgeScreenRoute> {
                AgeScreen {
                    navHostController.navigate(HeightScreenRoute)
                }
            }
            composable<HeightScreenRoute> {
                HeightScreen {
                    navHostController.navigate(WeightScreenRoute)
                }
            }
            composable<WeightScreenRoute> {
                WeightScreen {
                    navHostController.navigate(ActivityLevelScreenRoute)
                }
            }
            composable<ActivityLevelScreenRoute> {
                ActivityLevelScreen {
                    navHostController.navigate(GoalScreenRoute)
                }
            }
            composable<GoalScreenRoute> {
                GoalScreen {
                    navHostController.navigate(NutrientGoalScreenRoute)
                }
            }
            composable<NutrientGoalScreenRoute> {
                NutrientGoalScreen {
                    navHostController.navigate(TrackerOverviewScreenRoute)
                }
            }
            composable<TrackerOverviewScreenRoute> {
                TrackerOverviewScreen()
            }
        }
    }
}