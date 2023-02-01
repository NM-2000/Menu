package com.nm_2000.menu.view

sealed class Orientation(val route: String) {
    object ListOrientation : Orientation("list_orientation")
    object GridOrientation : Orientation("grid_orientation")
}
