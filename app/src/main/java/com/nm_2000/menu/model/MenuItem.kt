package com.nm_2000.menu.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("menu_item_table")
data class MenuItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("name")
    val title: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("extra")
    val label: String?
)
