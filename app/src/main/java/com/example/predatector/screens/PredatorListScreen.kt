package com.example.predatector.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.firstandroidapp.components.drawer.DrawerMenu
import com.example.predatector.models.MenuItem
import com.example.predatector.models.Predator
import com.example.predatector.navigation.Screen
import com.example.predatector.repository.PredatorRepository

@Composable
fun PredatorListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val menuItems = listOf(
        MenuItem("Map", Icons.Default.Home, { navController.navigate(Screen.Map.route) }, false),
        MenuItem("Predator list", Icons.Default.Person, { /* Already here */ }, true),
        MenuItem("Watch list", Icons.Default.Warning, { navController.navigate(Screen.WatchList.route) }, false)
    )

    var predators by remember { mutableStateOf<List<Predator>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            predators = PredatorRepository.fetchPredators()
        } catch (e: Exception) {
            errorMessage = e.localizedMessage ?: "Unknown error occurred"
        } finally {
            isLoading = false
        }
    }

    DrawerMenu(menuItems) {
        when {
            isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            errorMessage != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: $errorMessage",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = modifier
                ) {
                    items(predators) { predator ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                                .clickable {
                                    // TODO: Add navigation to details screen
                                }
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = rememberAsyncImagePainter(predator.picture.large),
                                    contentDescription = predator.name.first,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                )
                                Text(
                                    "${predator.name.first} ${predator.name.last}",
                                    modifier = Modifier.padding(8.dp)
                                )
                                Text(predator.location.city, style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                }
            }
        }
    }
}
