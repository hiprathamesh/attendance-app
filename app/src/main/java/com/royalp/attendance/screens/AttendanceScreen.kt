package com.royalp.attendance.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.interFontFamily
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.royalp.attendance.components.HomeScreenDropdownMenu
import com.royalp.attendance.components.HomeScreenHeader

@Composable
fun AttendanceScreen(onClick : (scoutName: String)-> Unit) {
    val scrollStateAS = rememberScrollState()
    var excludeMedicalAttendance by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var started by remember { mutableIntStateOf(0) }
    var ended by remember { mutableIntStateOf(3) }
    Column(modifier = Modifier
        .padding(16.dp, 40.dp, 16.dp, 80.dp)
        .verticalScroll(scrollStateAS)) {
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
            },
            title = "Attendance"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text="Your current attendance is 75%", fontFamily = interFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Text(text="Attend 67 of the remaining 105 classes to keep your overall attendance over 75%", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text="FILTERS", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 9.sp)
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var selected by remember { mutableStateOf("Subject") }
            FilterChip(
                selected = selected == "Subject",
                onClick = {
                    selected = "Subject"
                    started = 0
                    ended = 3
                          },
                label = {
                    Text(
                        text="Subject",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.height(30.dp)
            )
            FilterChip(
                selected = selected == "Month",
                onClick = {
                    selected = "Month"
                    started=4
                    ended=6
                          },
                label = {
                    Text(
                        text="Month",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.height(30.dp)
            )
            FilterChip(
                selected = selected == "Semester",
                onClick = {
                    selected = "Semester"
                    started=7
                    ended=7
                          },
                label = {
                    Text(
                        text="Semester",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.height(30.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text="Exclude Medical Attendance", fontFamily = interFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            Switch(
                checked = excludeMedicalAttendance,
                onCheckedChange = { excludeMedicalAttendance = it },
                modifier = Modifier
                    .graphicsLayer(
                        scaleX = 0.6f,
                        scaleY = 0.6f
                    )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        SubjectAttendanceList(started,ended)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(text = "Scout Sets", fontFamily = interFontFamily, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Scout Set", modifier = Modifier.size(24.dp))
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        ScoutSetItem("Roommates", 16, onClick )
        ScoutSetItem("Classmates", 74,onClick)
        ScoutSetItem("CSE Friends", 11,onClick)
    }
}

@Composable
fun SubjectAttendanceList(start:Int, end:Int) {
    val subjects = listOf(
        SubjectAttendance("Engineering\nPhysics", 63, Color(0xFF6EA8FF), Color(0xFFAFD4FF)),
        SubjectAttendance("Engineering\nMathematics II", 22, Color(0xFFFFDC61), Color(0xFFFDFF9D)),
        SubjectAttendance("Engineering\nGraphics", 99, Color(0xFFDCC1FF), Color(0xFFF5E5FF)),
        SubjectAttendance("Data Structures\n& Algorithms", 72, Color(0xFF77FFA5), Color(0xFFB4FFD6)),
        SubjectAttendance("July", 33, Color(0xFF6EA8FF), Color(0xFFAFD4FF)),
        SubjectAttendance("August", 100, Color(0xFFFFDC61), Color(0xFFFDFF9D)),
        SubjectAttendance("September", 58, Color(0xFFDCC1FF), Color(0xFFF5E5FF)),
        SubjectAttendance("Semester V", 85, Color(0xFFDCC1FF), Color(0xFFF5E5FF))
    )
    for(x in start..end) {
        SubjectAttendanceCard(subjects[x])
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun SubjectAttendanceCard(subject: SubjectAttendance) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = subject.color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = subject.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "${subject.attendance}",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = subject.color2
            )
        }
    }
}

@Composable
fun ScoutSetItem(name: String, count: Int,onClick: (scoutName: String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(name)
            },
        verticalAlignment = Alignment.CenterVertically,
        ) {
        Text(
            text = name,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Text(text = count.toString(),
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(Icons.Outlined.Person, contentDescription = null, modifier = Modifier.size(20.dp))
    }
    Spacer(modifier = Modifier.height(12.dp))
}

data class SubjectAttendance(val name: String, val attendance: Int, val color: Color, val color2: Color)