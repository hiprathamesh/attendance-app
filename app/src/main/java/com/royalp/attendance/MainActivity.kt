package com.royalp.attendance

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FrontHand
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FrontHand
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily
import com.royalp.attendance.screens.HomeScreen
import com.royalp.attendance.screens.AttendanceScreen
import com.royalp.attendance.screens.SettingsScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendanceTheme {
                val navController = rememberNavController()

                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selected = Icons.Filled.Home,
                        unSelected = Icons.Outlined.Home,
                    ),
                    BottomNavigationItem(
                        title = "Profile",
                        selected = Icons.Filled.FrontHand,
                        unSelected = Icons.Outlined.FrontHand,
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selected = Icons.Filled.AccountCircle,
                        unSelected = Icons.Outlined.AccountCircle,
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
                                        navController.navigate(item.title)
                                    },
                                    label = { Text(text = item.title, fontFamily = interFontFamily) },
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
                    NavHost(navController=navController, startDestination = "home") {
                        composable(route="home"){
                            HomeScreen()
                        }
                        composable(route="profile"){
                            AttendanceScreen()
                        }
                        composable(route="settings") {
                            SettingsScreen()
                        }
                    }

                }
            }
        }
    }
}
