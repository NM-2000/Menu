package com.nm_2000.menu.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nm_2000.menu.ui.theme.*

@Composable
fun HeaderComposable(
    searchText: String,
    focusManager: FocusManager,
    updateSearchText: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Header_Color)
            .padding(34.dp, 29.dp, 34.dp, 21.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 6.dp, 0.dp, 8.dp)
        ) {
            Text(
                "Explore",
                textAlign = TextAlign.Start,
                color = Header_Title_Color,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                "Filter",
                textAlign = TextAlign.End,
                color = Header_Filter_Color,
                fontSize = 16.sp,
                lineHeight = 19.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomEnd)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Search_Bar_Border_Color),
            value = searchText,
            onValueChange = {
                updateSearchText(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Search_Bar_Color,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Search_Bar_Cursor_Color
            ),
            textStyle = TextStyle(
                color = Search_Bar_Text_Color,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 19.sp
            ),
            shape = CircleShape,
            singleLine = true,
            placeholder = {
                Text(
                    "Search",
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.W500,
                    color = Search_Bar_Text_Color
                )
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                },
                onGo = {
                    focusManager.clearFocus()
                },
                onSearch = {
                    focusManager.clearFocus()
                },
                onSend = {
                    focusManager.clearFocus()
                },
            )
        )
    }
}