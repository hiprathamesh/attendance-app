package com.royalp.attendance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily
import com.royalp.attendance.components.LectureCard

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    AttendanceTheme {
        val scrollStateHS = rememberScrollState()
        Column(modifier = Modifier.padding(16.dp,40.dp,16.dp,80.dp).verticalScroll(scrollStateHS)){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Home", fontFamily = interFontFamily, fontWeight = FontWeight.Bold, fontSize = 30.sp)
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                        modifier = Modifier.height(42.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="Good Morning,\nPrathamesh", fontFamily = interFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="Your Classes for Today", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(0)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(1)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(2)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(2)
            Spacer(modifier = Modifier.height(32.dp))
            Text(text="Tomorrow", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(0)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(1)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(2)
            Spacer(modifier = Modifier.height(16.dp))
            LectureCard(2)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}