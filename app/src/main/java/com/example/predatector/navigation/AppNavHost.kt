package com.example.predatector.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.predatector.screens.MapScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Map.route) {
        composable(Screen.Map.route) {
            MapScreen(navController)
        }
        composable(Screen.PredatorList.route) {
            MapScreen(navController)
        }
        composable(Screen.WatchList.route) {
            MapScreen(navController)
        }
        composable(Screen.Details.route) {
            MapScreen(navController)
        }
    }
}