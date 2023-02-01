package com.nm_2000.menu.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nm_2000.menu.model.MenuItem
import com.nm_2000.menu.ui.theme.Menu_Item_Border_Color
import com.nm_2000.menu.ui.theme.Menu_Item_Color
import com.nm_2000.menu.ui.theme.Menu_Item_Label_Color

@Composable
fun ListComposable(
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
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(34.dp, 40.dp, 34.dp, 0.dp)
        ) {
            itemsIndexed(
                menuItems.filter { item ->
                    item.title.lowercase().contains(searchText.lowercase())
                }
            ) { _, item ->
                ListItem(item)

            }
        }
    }
}

@Composable
fun ListItem(
    menuItem: MenuItem,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 14.dp)
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(
                    color = Menu_Item_Color,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(66.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                text = menuItem.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 19.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 32.dp, 0.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Menu_Item_Label_Color,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                        ) {
                            append("MRP: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                        ) {
                            append("${menuItem.price}")
                        }
                    },
                    lineHeight = 17.sp,
                    modifier = Modifier
                        .align(Alignment.Bottom)
                )
                menuItem.label?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.Bottom),
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        color = Menu_Item_Label_Color,
                        lineHeight = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Menu_Item_Border_Color)
            )

        }
    }
}