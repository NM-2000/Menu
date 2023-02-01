package com.nm_2000.menu.data

import com.nm_2000.menu.model.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuItemRepository
@Inject
constructor(private val menuItemDAO: MenuItemDAO) {
    suspend fun readAllMenuItems(): List<MenuItem> = withContext(Dispatchers.IO) {
        menuItemDAO.readAllMenuItems()
    }

    suspend fun addMenuItem(menuItem: MenuItem) {
        menuItemDAO.addMenuItem(menuItem)
    }
}