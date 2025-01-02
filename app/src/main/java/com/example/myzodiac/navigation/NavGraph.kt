package com.example.myzodiac.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myzodiac.ZodiacScreen
import com.example.myzodiac.model.ZodiacRepository
import com.example.myzodiac.ui.views.BirthdateScreen
import com.example.myzodiac.ui.views.ZodiacDetailScreen
import com.example.myzodiac.viewmodel.ZodiacViewModel

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Birthdate : Screen("birthdate")
    object ZodiacDetail : Screen("zodiacDetail")
}

@Composable
fun ZodiacNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    val zodiacViewModel: ZodiacViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            ZodiacScreen(
                modifier = Modifier,
                onExploreClick = {
                    navController.navigate(Screen.Birthdate.route)
                }
            )
        }
        composable(Screen.Birthdate.route) {
            BirthdateScreen(
                viewModel = zodiacViewModel,
                onNextClick = {
                    navController.navigate(Screen.ZodiacDetail.route)
                }
            )
        }
        composable(Screen.ZodiacDetail.route) {
            ZodiacDetailScreen(
                viewModel = zodiacViewModel,
                onCheckAnotherClick = {
                    navController.navigate(Screen.Birthdate.route) {
                        popUpTo(Screen.Birthdate.route)
                    }
                }
            )
        }
    }
}