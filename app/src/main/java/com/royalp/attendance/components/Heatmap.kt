package com.royalp.attendance.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@Composable
fun Heatmap() {
    val c1=Color(0xFF6BFF7A)
    val c2=Color(0xFFFF7777)
    val c3=Color(0xFF7D7D7D)
    val c4=Color(0xFF6BC1FF)
    val attendanceData = listOf(
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        listOf(c1,c2,c3,c4,c2,c1),
        // Add more columns as per your data
    )

    val startDate = LocalDate.of(2024, 9, 9) // Starting date for the heatmap

    LazyRow(
        modifier = Modifier
            .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(attendanceData) { index, column ->
            val currentDate = startDate.plusDays(index.toLong())
            HeatmapColumn(column, currentDate, startDate)
        }
    }
}

@Composable
fun HeatmapColumn(colors: List<Color>, date: LocalDate, startDate: LocalDate) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentSize()
    ) {
        // Month text
        if (date.dayOfMonth == 1 || date == startDate) {
            Text(
                text = date.month.name.substring(0, 3),
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        else{
            Text(
                text = "",
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 4.dp),
                color = Color(0x00000000)
            )
        }
        // Date text
        Text(
            text = date.dayOfMonth.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Color blocks
        colors.forEach { color ->
            HeatmapBlock(color)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun HeatmapBlock(color: Color) {
    Card(
        modifier = Modifier.size(20.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ){

    }
}
