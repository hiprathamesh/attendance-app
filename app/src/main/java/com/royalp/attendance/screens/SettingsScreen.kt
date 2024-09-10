package com.royalp.attendance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Backup
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Dataset
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Fingerprint
import androidx.compose.material.icons.outlined.FrontHand
import androidx.compose.material.icons.outlined.HideSource
import androidx.compose.material.icons.outlined.InvertColors
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PersonRemove
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.R
import com.royalp.attendance.components.Heatmap
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily

@Preview(showBackground = true)
@Composable
fun SettingsScreen() {
    AttendanceTheme {
        val scrollStateSS = rememberScrollState()
        val scrollStateFS = rememberScrollState()
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
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                        modifier = Modifier.height(42.dp)
                    )
                }
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
                modifier = Modifier
                    .wrapContentSize()
                    .horizontalScroll(scrollStateFS),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChip(
                    selected = false,
                    onClick = { /* TODO */ },
                    label = {
                        Text(
                            text="CSE311",
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
                            text="CSE312",
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
                            text="CSE313",
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
                            text="CSE314",
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
                            text="CSE315",
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
                            text="CSE316",
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
            Spacer(modifier = Modifier.height(8.dp))
            Heatmap()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Settings",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="GENERAL", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItem("Notifications",Icons.Outlined.Notifications)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Reminder for Lectures",Icons.Outlined.DateRange)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("When App Opens", Icons.AutoMirrored.Outlined.MenuOpen,0)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("App Language",Icons.Outlined.Language,0)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Confirm Exit", Icons.AutoMirrored.Outlined.ExitToApp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="APPEARANCE", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItem("Dark Mode",Icons.Outlined.DarkMode)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Use System Appearance",Icons.Outlined.Settings)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("App Theme Color",Icons.Outlined.InvertColors,0)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="ATTENDANCE", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItem("Start Week on Sunday",Icons.Outlined.Event)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Default Attendance Filter",Icons.Outlined.FrontHand,0)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Show Scout Sets' Strength",Icons.Outlined.Dataset)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="USER", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItem("Change Password",Icons.Outlined.Password,0)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Edit Your Profile",Icons.Outlined.Person,0)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Delete Account",Icons.Outlined.PersonRemove,0)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text="PRIVACY", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItem("Use Biometric Unlock",Icons.Outlined.Fingerprint)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Keep Attendance Hidden",Icons.Outlined.HideSource)
            Spacer(modifier = Modifier.height(16.dp))
            SettingsItem("Backup at iCloud",Icons.Outlined.Backup)
            Spacer(modifier = Modifier.height(32.dp))
            SettingsItem("Log Out", Icons.AutoMirrored.Outlined.Logout,2)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview
@Composable
fun SettingsItem(title:String="Notifications", icon: ImageVector =Icons.Default.Add, status: Int=1) {
    Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Row{
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFCCCCCC))
            ){
                Icon(
                    imageVector = icon,
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp).padding(3.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text=title, fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp)
        }
        when (status) {
            1 -> {
                Switch(
                    checked = true,
                    onCheckedChange = { /* TODO */ },
                    modifier = Modifier
                        .scale(0.7f)
                        .size(30.dp, 15.dp)
                        .wrapContentSize()
                )
            }
            2 -> return
            else -> {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Forward",
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}