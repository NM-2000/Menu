package com.nm_2000.menu.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nm_2000.menu.data.MenuItemRepository
import com.nm_2000.menu.model.ApiResponse
import com.nm_2000.menu.model.MenuItem
import com.nm_2000.menu.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel
@Inject
constructor(private val menuItemRepository: MenuItemRepository) : ViewModel() {

    var menuItemResponse: List<MenuItem> by mutableStateOf(listOf())

    init {
        readAllMenuItems()
    }

    private fun addMenuItem(menuItem: MenuItem) {
        viewModelScope.launch(Dispatchers.IO) {
            menuItemRepository.addMenuItem(menuItem)
        }
    }

    fun readAllMenuItems() {
        viewModelScope.launch {
            menuItemResponse = menuItemRepository.readAllMenuItems()
            if (menuItemResponse.isEmpty()) {
                Log.d("DEBUGGING: ", "Making API Call")
                val apiService = ApiService.getInstance()
                try {
                    val apiResponse: ApiResponse = apiService.getApiResponse()
                    val menuItems = apiResponse.data.items
                    menuItems.forEachIndexed { index, menuItem ->
                        Log.d("ITEM", menuItem.toString())
                        addMenuItem(MenuItem(index, menuItem.title, menuItem.price, menuItem.label))

                    }
                    menuItemResponse = menuItems
                } catch (e: Exception) {
                    Log.e("API_FETCH_ERROR", e.stackTraceToString())
                }
            }
        }
    }

}