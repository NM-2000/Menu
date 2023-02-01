package com.nm_2000.menu.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nm_2000.menu.model.MenuItem

@Dao
interface MenuItemDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMenuItem(menuItem: MenuItem)

    @Query("SELECT * FROM menu_item_table ORDER BY id ASC")
    fun readAllMenuItems(): List<MenuItem>

}