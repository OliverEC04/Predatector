package com.example.predatector.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.firstandroidapp.components.drawer.DrawerMenu
import com.example.predatector.models.MenuItem
import com.example.predatector.navigation.Screen

@Composable
fun MapScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(
        MenuItem("Map", Icons.Default.Home, { navController.navigate(Screen.Map.route) }, true),
        MenuItem(
            "Predator list",
            Icons.Default.Person,
            { navController.navigate(Screen.PredatorList.route) }),
        MenuItem(
            "Watch list",
            Icons.Default.Warning,
            { navController.navigate(Screen.WatchList.route) })
    )

    DrawerMenu(menuItems) {
        Text(text = "MapScreen", modifier = modifier)
    }
}