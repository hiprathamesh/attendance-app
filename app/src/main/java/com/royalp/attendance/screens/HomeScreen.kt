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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily
import com.royalp.attendance.components.LectureCard
import com.royalp.attendance.components.HomeScreenDropdownMenu
import com.royalp.attendance.components.HomeScreenHeader


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    AttendanceTheme {
        val scrollStateHS = rememberScrollState()
        var expanded by remember { mutableStateOf(false) }
        Column(modifier = Modifier
            .padding(16.dp, 40.dp, 16.dp, 80.dp)
            .verticalScroll(scrollStateHS)){
            HomeScreenHeader(
                expanded = expanded,
                onMoreClick = { expanded = true },
                dropdownContent = {
                    HomeScreenDropdownMenu(
                        expanded = expanded,
                        onDismiss = { expanded = false },
                        onMenuItemClick = { item ->
                            // Handle menu item click
                            when (item) {
                                "Edit Profile" -> { /* Handle Edit Profile */ }
                                "Settings" -> { /* Handle Settings */ }
                                "Help / Support" -> { /* Handle Help */ }
                                "Log Out" -> { /* Handle Log Out */ }
                                "Feedback" -> { /* Handle Feedback */ }
                                "App Info" -> { /* Handle App Info */ }
                            }
                        }
                    )
                }
            )
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
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6EA8FF))
                ) {
                    Text(
                        text = "See Full Schedule",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}