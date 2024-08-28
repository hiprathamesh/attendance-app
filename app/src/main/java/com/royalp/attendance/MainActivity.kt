package com.royalp.attendance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.royalp.attendance.ui.theme.AttendanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendanceTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selected = Icons.Filled.Home,
                        unSelected = Icons.Outlined.Home,
                    ),
                    BottomNavigationItem(
                        title = "Profile",
                        selected = Icons.Filled.Home,
                        unSelected = Icons.Outlined.Home,
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selected = Icons.Filled.Home,
                        unSelected = Icons.Outlined.Home,
                    )
                )
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }
                Scaffold (
                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    onClick = {
                                        selectedItemIndex = index
                                        //navController.navigate(item.title)
                                    },
                                    label = { Text(text = item.title) },
                                    icon = {
                                        BadgedBox(
                                            badge = {}
                                        ) {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selected
                                                } else item.unSelected,
                                                contentDescription = item.title
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                ){
                    Text(
                        text = "Hello World!",
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}
