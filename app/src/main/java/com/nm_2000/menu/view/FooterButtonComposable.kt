package com.nm_2000.menu.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.nm_2000.menu.ui.theme.Footer_Button_Active_Color
import com.nm_2000.menu.ui.theme.Footer_Button_Inactive_Color

@Composable
fun FooterButton(
    buttonId: String,
    activeTab: String,
    setActiveTab: (String) -> Unit,
    enabled: Boolean = true,
    navController: NavHostController,
    route: String = ""
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
            .background(
                color = if (activeTab == buttonId) Footer_Button_Active_Color else Footer_Button_Inactive_Color,
                shape = CircleShape
            )
            .layoutId(buttonId)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled
            ) {
                setActiveTab(buttonId)
                navController.popBackStack()
                navController.navigate(route)
            }
    )
}