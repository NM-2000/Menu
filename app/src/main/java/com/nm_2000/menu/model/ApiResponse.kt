package com.nm_2000.menu.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("error")
    val error: String?,
    @SerializedName("data")
    val data: Data
)
