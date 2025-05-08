package com.example.predatector.navigation

sealed class Screen(val route: String) {
    object Map : Screen("map")
    object PredatorList : Screen("screens/PredatorListScreen")
    object WatchList : Screen("screens/watch-list")
    object Details : Screen("screens/details")
}