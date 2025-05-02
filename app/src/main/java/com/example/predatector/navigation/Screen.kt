package com.example.predatector.navigation

sealed class Screen(val route: String) {
    object Map : Screen("map")
    object Detail : Screen("screens/car2")
}