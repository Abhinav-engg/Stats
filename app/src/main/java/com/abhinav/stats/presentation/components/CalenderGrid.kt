//package com.abhinav.stats.presentation.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
////import com.abhinav.stats.presentation.screens.home.heatmapColors
////import com.abhinav.stats.presentation.screens.home.textColorFor
////import com.abhinav.stats.presentation.screens.home.weekdayLabels
//import com.abhinav.stats.ui.theme.Divider
//import com.abhinav.stats.ui.theme.TextSecondary
//
//@Composable
//fun CalendarGrid(daysInMonth: Int, startOffset: Int, monthStartIndex: Int) {
//    val totalCells = startOffset + daysInMonth
//    val rows = (totalCells + 6) / 7
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(1.dp, Divider, RoundedCornerShape(16.dp))
//            .padding(12.dp)
//    ) {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            for (label in weekdayLabels) {
//                Text(
//                    text = label,
//                    modifier = Modifier.weight(1f),
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = TextSecondary,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        var day = 1
//        for (row in 0 until rows) {
//            Row(modifier = Modifier.fillMaxWidth()) {
//                for (col in 0 until 7) {
//                    val cellPosition = row * 7 + col
//                    if (cellPosition < startOffset || day > daysInMonth) {
//                        Box(
//                            modifier = Modifier
//                                .weight(1f)
//                                .aspectRatio(1f)
//                        )
//                    } else {
//                        val color = heatmapColors[(monthStartIndex + day - 1) % heatmapColors.size]
//                        Box(
//                            modifier = Modifier
//                                .weight(1f)
//                                .aspectRatio(1f)
//                                .padding(3.dp)
//                                .clip(RoundedCornerShape(10.dp))
//                                .background(color),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                text = day.toString(),
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = textColorFor(color)
//                            )
//                        }
//                        day++
//                    }
//                }
//            }
//        }
//    }
//}