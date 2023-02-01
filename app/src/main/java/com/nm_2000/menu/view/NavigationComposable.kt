package com.nm_2000.menu.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nm_2000.menu.model.MenuItem

@Composable
fun NavigationComposable(
    navController: NavHostController,
    searchText: String,
    menuItems: List<MenuItem>
) {
    NavHost(navController = navController, startDestination = Orientation.ListOrientation.route) {
        composable(Orientation.ListOrientation.route) {
            ListComposable(searchText, menuItems)
        }
        composable(Orientation.GridOrientation.route) {
            GridComposable(searchText, menuItems)
        }
    }
}