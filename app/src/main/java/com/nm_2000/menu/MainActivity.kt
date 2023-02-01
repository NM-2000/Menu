package com.nm_2000.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import com.nm_2000.menu.ui.theme.Background_Color
import com.nm_2000.menu.view.FooterBorderComposable
import com.nm_2000.menu.view.FooterComposable
import com.nm_2000.menu.view.HeaderComposable
import com.nm_2000.menu.view.NavigationComposable
import com.nm_2000.menu.viewModel.MenuItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val menuItemViewModel: MenuItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var searchText by remember {
                mutableStateOf("")
            }
            var activeTab by remember {
                mutableStateOf("tabOne")
            }
            val navController = rememberNavController()
            val focusManager = LocalFocusManager.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background_Color)
            ) {
                HeaderComposable(
                    searchText = searchText,
                    focusManager
                ) {
                    searchText = it
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    NavigationComposable(
                        navController,
                        searchText,
                        menuItemViewModel.menuItemResponse
                    )
                }
                FooterBorderComposable()
                FooterComposable(
                    navController = navController,
                    activeTab = activeTab
                ) {
                    activeTab = it
                }
            }
        }
    }
}