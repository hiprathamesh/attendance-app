package com.royalp.attendance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.royalp.attendance.components.HomeScreenDropdownMenu
import com.royalp.attendance.components.HomeScreenHeader
import com.royalp.attendance.components.LecListViewModel
import com.royalp.attendance.components.LectureCard
import com.royalp.attendance.ui.theme.interFontFamily

@Preview
@Composable
fun LecListScreen(viewModel: LecListViewModel = viewModel()) {
    val lecs1 by viewModel.lecList1.collectAsStateWithLifecycle()
    val lecs2 by viewModel.lecList2.collectAsStateWithLifecycle()
    var expanded by remember { mutableStateOf(false) }

        LazyColumn(
            modifier = Modifier.padding(16.dp, 40.dp, 16.dp, 80.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
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
            }
            item {
                Text(text="Your Classes for Today", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
            items(lecs1){ lec ->
                LectureCard(lec.status, lec.name, lec.short, lec.code, lec.start, lec.end, lec.prof)
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text="Tomorrow", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
            }
            items(lecs2){ lec ->
                LectureCard(lec.status, lec.name, lec.short, lec.code, lec.start, lec.end, lec.prof)
            }
            item{
                Spacer(modifier = Modifier.height(0.dp))
            }
            /*
            item {
                ClassDetailsButton { classDetails, documentID ->
                    createLec(classDetails, documentID)
                }
            }
             */
        }

}