package com.royalp.attendance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.royalp.attendance.R
import com.royalp.attendance.ui.theme.AttendanceTheme
import com.royalp.attendance.ui.theme.interFontFamily

@Composable
fun ScoutScreen(scoutName: String, onClick: () -> Unit) {
    AttendanceTheme {
        val scrollStateSS = rememberScrollState()
        Column(modifier=Modifier.fillMaxSize().zIndex(2F), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom){
            Button(onClick = {onClick()},modifier=Modifier.offset(0.dp,(-112).dp).zIndex(2F)) {
                Text(
                    text = "Done",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp, 4.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp, 40.dp, 0.dp, 80.dp)
                .verticalScroll(scrollStateSS)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = scoutName,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "More",
                        modifier = Modifier.height(42.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            ScoutCard()
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Total Members: 24",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
                color = Color(0xFF909090)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun ScoutCard(name:String="Prathamesh Prashant Nikam",scholar:String="22U02050",pic:Int=R.drawable.profilepic) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier= Modifier
        .fillMaxWidth()
        .padding(0.dp, 0.dp, 16.dp, 0.dp)){
        Row{
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "Your image description",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Prathamesh Prashant Nikam",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
                Text(
                    text = "22U02050",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
        Text(
            text = "75%",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
    HorizontalDivider(thickness = 0.75.dp)
    Spacer(modifier = Modifier.height(12.dp))
}