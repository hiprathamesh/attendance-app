package com.royalp.attendance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.R
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily

@Preview
@Composable
fun SettingsScreen() {
    AttendanceTheme {
        val scrollStateSS = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(16.dp, 40.dp, 16.dp, 80.dp)
                .verticalScroll(scrollStateSS)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Profile",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    modifier = Modifier.height(42.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "Your image description",
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column{
                    Text(text="Prathamesh Prashant Nikam", fontFamily = interFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Text(text="Pre-Final Year", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp)
                    Text(text="IIIT Bhopal, CSE (2026)", fontFamily = interFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="Your Attendance Chart", fontFamily = interFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.wrapContentSize(),
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
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(30.dp)
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
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(30.dp)
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
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Settings",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}