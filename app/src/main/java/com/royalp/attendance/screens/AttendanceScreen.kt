package com.royalp.attendance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun AttendanceScreen() {
    val scrollStateAS = rememberScrollState()
    var excludeMedicalAttendance by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp,40.dp,16.dp,80.dp).verticalScroll(scrollStateAS)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(text = "Attendance", fontFamily = interFontFamily, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More", modifier = Modifier.height(42.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text="Your current attendance is 75%", fontFamily = interFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Text(text="Attend 67 of the remaining 105 classes to keep your overall attendance over 75%", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text="FILTERS", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 9.sp)
        FilterSection()
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
        SubjectAttendanceList()
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(text = "Scout Sets", fontFamily = interFontFamily, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Scout Set", modifier = Modifier.size(24.dp))
            }
        }
        ScoutSetsSection()
    }
}


@Composable
fun FilterSection() {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = false,
            onClick = { /* TODO */ },
            label = {
                Text(
                    text="Subject",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            },
            shape = RoundedCornerShape(20.dp)
        )
        FilterChip(
            selected = false,
            onClick = { /* TODO */ },
            label = {
                Text(
                    text="Month",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            },
            shape = RoundedCornerShape(20.dp)
        )
        FilterChip(
            selected = false,
            onClick = { /* TODO */ },
            label = {
                Text(
                    text="Semester",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            },
            shape = RoundedCornerShape(20.dp)
        )
    }
}

@Composable
fun SubjectAttendanceList() {
    val subjects = listOf(
        SubjectAttendance("Engineering\nPhysics", 63, Color(0xFF6EA8FF), Color(0xFFAFD4FF)),
        SubjectAttendance("Engineering\nMathematics II", 22, Color(0xFFFFDC61), Color(0xFFFDFF9D)),
        SubjectAttendance("Engineering\nGraphics", 99, Color(0xFFDCC1FF), Color(0xFFF5E5FF)),
        SubjectAttendance("Data Structures\n& Algorithms", 72, Color(0xFF77FFA5), Color(0xFFB4FFD6))
    )
    for(x in subjects) {
        SubjectAttendanceCard(x)
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
fun ScoutSetsSection() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        ScoutSetItem("Roommates", 16)
        Spacer(modifier = Modifier.height(8.dp))
        ScoutSetItem("Classmates", 74)
        Spacer(modifier = Modifier.height(8.dp))
        ScoutSetItem("CSE Friends", 11)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ScoutSetItem(name: String, count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(1f)
        )
        Text(text = count.toString())
        Spacer(modifier = Modifier.width(4.dp))
        Icon(Icons.Outlined.Person, contentDescription = null)
    }
}

data class SubjectAttendance(val name: String, val attendance: Int, val color: Color, val color2: Color)