package com.nm_2000.menu.data.di

import android.app.Application
import androidx.room.Room
import com.nm_2000.menu.data.MenuItemDAO
import com.nm_2000.menu.data.MenuItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MenuItemDatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): MenuItemDatabase =
        Room.databaseBuilder(
            application,
            MenuItemDatabase::class.java,
            "menu_item_database"
        ).build()

    @Provides
    @Singleton
    fun providesDAO(menuItemDatabase: MenuItemDatabase): MenuItemDAO =
        menuItemDatabase.menuItemDAO()

}