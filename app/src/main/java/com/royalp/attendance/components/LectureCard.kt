package com.royalp.attendance.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily

@Preview(showBackground = true)
@Composable
fun LectureCard(
    status: Int = 2,
    name: String = "Engineering Physics II",
    short: String = "PHY",
    code: String = "102",
    start: String = "10:00",
    end: String = "12:00",
    prof: String = "Dr. Nikita Acharya",
    extraInfo: String = "Extra Info Here!"
) {
    AttendanceTheme {
        var expanded by remember { mutableStateOf(false) }
        val rotationState by animateFloatAsState(
            targetValue = if (expanded) 180f else 0f,
            label = ""
        )

        var mes = "UPC"
        var color = Color(0xFF5C9DFF)
        if (status == 0) {
            mes = "MSD"
            color = Color(0xFFFD7254)
        } else if (status == 1) {
            mes = "ATD"
            color = Color(0xFF77FFA5)
        }

        Box {
            Card(
                modifier = Modifier
                    .border(BorderStroke((0.5).dp, if(isSystemInDarkTheme()) Color.White else Color.Black), shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = true),
                        onClick = { expanded = !expanded }
                    )
                    .animateContentSize(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x00000000))
            ) {
                Column(modifier = Modifier.padding(0.dp, 8.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(12.dp, 2.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = short,
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 50.sp
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = code,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Card(
                                modifier = Modifier,
                                shape = RoundedCornerShape(100.dp),
                                colors = CardDefaults.cardColors(containerColor = color)
                            ) {
                                Text(
                                    text = mes,
                                    fontFamily = interFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(16.dp, 0.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = start,
                                    fontFamily = interFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp,
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = "TO",
                                    fontFamily = interFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 6.sp,
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = end,
                                    fontFamily = interFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp,
                                )
                            }
                            Text(
                                text = prof,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 13.sp,
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ExpandMore,
                            contentDescription = "Expand",
                            modifier = Modifier.rotate(rotationState)
                        )
                    }
                    if (expanded) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = extraInfo,
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(12.dp, 0.dp)
                        )
                    }
                }
            }
            Text(
                text = " $name ",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .absoluteOffset(20.dp, (-10).dp)
                    .background(if(isSystemInDarkTheme())Color(0xFF121317) else Color(0xFFFAF9FE))
            )
        }
    }
}