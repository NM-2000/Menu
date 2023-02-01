package com.nm_2000.menu.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("items")
    val items: List<MenuItem>
)
