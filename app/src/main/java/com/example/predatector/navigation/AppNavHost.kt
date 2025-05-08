package com.example.predatector.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.predatector.screens.Car1
import com.example.predatector.screens.Car2
import com.example.predatector.screens.MapScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Map.route) {
        composable(Screen.Map.route) {
            MapScreen(navController)
        }
        composable(Screen.Detail.route) {
            Car2(navController)
        }
    }
}