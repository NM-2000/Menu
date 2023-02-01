package com.nm_2000.menu.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nm_2000.menu.model.MenuItem
import com.nm_2000.menu.ui.theme.Menu_Item_Color

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridComposable(
    searchText: String,
    menuItems: List<MenuItem>,
    modifier: Modifier = Modifier
) {
    if (menuItems.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    } else {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp, 40.dp, 16.dp, 0.dp),
        ) {
            itemsIndexed(
                menuItems.filter { item ->
                    item.title.lowercase().contains(searchText.lowercase())
                }
            ) { _, item ->
                GridItem(menuItem = item)
            }
        }
    }
}

@Composable
fun GridItem(
    menuItem: MenuItem
) {
    Column(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 28.dp)
    ) {
        Box(
            modifier = Modifier
                .width(110.dp)
                .height(110.dp)
                .background(
                    color = Menu_Item_Color,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            menuItem.title,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            menuItem.price,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}