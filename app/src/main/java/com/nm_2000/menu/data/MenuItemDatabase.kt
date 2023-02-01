package com.nm_2000.menu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nm_2000.menu.model.MenuItem

@Database(entities = [MenuItem::class], version = 1, exportSchema = false)
abstract class MenuItemDatabase : RoomDatabase() {

    abstract fun menuItemDAO(): MenuItemDAO

    companion object {
        @Volatile
        private var INSTANCE: MenuItemDatabase? = null

        fun getDatabase(context: Context): MenuItemDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenuItemDatabase::class.java,
                    "menu_item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}