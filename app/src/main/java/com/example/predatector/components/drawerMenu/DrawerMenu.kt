package com.example.firstandroidapp.components.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.predatector.models.MenuItem
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(menuItems: List<MenuItem>, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed);
    val scope = rememberCoroutineScope();

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet(drawerContainerColor = Color.Gray) {
            Column(modifier = Modifier.padding(10.dp)) {
                IconButton(
                    onClick = { scope.launch { drawerState.close() } },
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Icon(
                        Icons.Default.Close, contentDescription = "close", tint = Color.White
                    )
                }
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(menuItems) { menuItem ->
                        DrawerMenuItem(
                            text = menuItem.name,
                            icon = menuItem.icon,
                            selected = menuItem.selected,
                            onClick = menuItem.onClick
                        )
                    }
                }
            }
        }
    }) {
        Scaffold(topBar = {
            IconButton(
                onClick = { scope.launch { drawerState.open() } },
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Icon(
                    Icons.Default.Menu, contentDescription = "menu", tint = Color.White
                )
            }
        }, containerColor = Color.Gray) { padding ->
            Box(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}