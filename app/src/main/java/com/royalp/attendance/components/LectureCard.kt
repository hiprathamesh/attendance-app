package com.royalp.attendance.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.royalp.attendance.ui.theme.interFontFamily

@Preview(showBackground = true)
@Composable
fun LectureCard(name:String="Engineering Physics II", short:String="PHY", code:String="102", status:Int=2, start:String="10:00", end:String="12:00", prof:String="Dr. Nikita Acharya") {
    var mes="UPC"
    var color=Color(0xFF5C9DFF)
    if(status==0){mes="MSD";color= Color(0xFFFD7254)}
    else if(status==1){mes="ATD";color= Color(0xFF77FFA5)}
    Box{
        Card(modifier = Modifier.border(BorderStroke((0.5).dp, Color.Black),shape = RoundedCornerShape(20.dp)), shape = RoundedCornerShape(20.dp),colors = CardDefaults.cardColors(containerColor = Color(0x00000000))){
            Column(modifier = Modifier.padding(0.dp,4.dp)){
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
                        fontSize = 45.sp,
                        color = Color.Black
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
                            fontSize = 16.sp,
                            color = Color.Black
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
                                modifier = Modifier.padding(16.dp,0.dp)
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
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                                text = "TO",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 6.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                                text = end,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }
                        Text(
                            text = prof,
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
        Text(text = " $name ", fontFamily = interFontFamily, fontWeight = FontWeight.Normal, fontSize = 10.sp, color = Color.Black, modifier = Modifier
            .absoluteOffset(20.dp, (-12).dp)
            .background(Color(0xFFFFFFFF)))
    }
}