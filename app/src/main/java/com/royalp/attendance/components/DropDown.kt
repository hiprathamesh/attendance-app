package com.royalp.attendance.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.interFontFamily

@Composable
fun HomeScreenHeader(expanded: Boolean, onMoreClick: () -> Unit, dropdownContent: @Composable () -> Unit,title:String="Home") {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Box {
            IconButton(onClick = onMoreClick) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    modifier = Modifier.height(42.dp)
                )
            }
            dropdownContent()
        }
    }
}

@Composable
fun HomeScreenDropdownMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onMenuItemClick: (String) -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(8.dp),
        containerColor = Color(0xFFF5F5F5),
        modifier = Modifier.width(140.dp),
    ) {
        listOf("Edit Profile", "Settings", "Help / Support", "Log Out", "Feedback", "App Info").forEach { item ->
            DropdownMenuItem(
                onClick = {
                    onMenuItemClick(item)
                    onDismiss()
                },
                text = { Text(item, fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 13.sp) }
            )
        }
    }
}