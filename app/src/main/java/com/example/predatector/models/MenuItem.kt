package com.example.predatector.models

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val name: String,
    val icon: ImageVector,
    val activity: Class<*>,
    val selected: Boolean = false
)
