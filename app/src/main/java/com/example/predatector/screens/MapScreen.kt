package com.example.predatector.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firstandroidapp.components.drawer.DrawerMenu
import com.example.predatector.models.MenuItem

@Composable
fun MapScreen(
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(
        MenuItem("Home", Icons.Default.Home, "map", true),
        MenuItem("Animals", Icons.Default.ShoppingCart, "car2")
    )

    DrawerMenu(menuItems) {
        Text(text = "MapScreen", modifier = modifier)
    }
}