package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.presentation.components.CalendarGrid
import com.abhinav.stats.ui.theme.Background
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.StatsTheme
import com.abhinav.stats.ui.theme.Surface
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

val heatmapColors = listOf(
    Color(0xFFE7E9ED), Color(0xFFBFEACB), Color(0xFF5EC488), Color(0xFF1F7A4D), Color(0xFF5EC488), Color(0xFFE7E9ED), Color(0xFFBFEACB),
    Color(0xFF1F7A4D), Color(0xFF5EC488), Color(0xFF5EC488), Color(0xFFBFEACB), Color(0xFF1F7A4D), Color(0xFFBFEACB), Color(0xFF5EC488),
    Color(0xFF5EC488), Color(0xFF1F7A4D), Color(0xFF5EC488), Color(0xFFBFEACB), Color(0xFF5EC488), Color(0xFFE7E9ED), Color(0xFFBFEACB),
    Color(0xFF5EC488), Color(0xFF1F7A4D), Color(0xFF5EC488), Color(0xFF5EC488), Color(0xFF1F7A4D), Color(0xFFBFEACB), Color(0xFF5EC488),
    Color(0xFF1F7A4D), Color(0xFF5EC488), Color(0xFFBFEACB), Color(0xFF1F7A4D), Color(0xFFE7E9ED), Color(0xFFE7E9ED), Color(0xFFE7E9ED)
)

val weekdayLabels = listOf("M", "T", "W", "T", "F", "S", "S")

val monthLabels = listOf("Oct 2024", "Nov 2024", "Dec 2024")
val monthDaysInMonth = listOf(31, 30, 31)
val monthStartOffset = listOf(1, 4, 6)
val monthStartIndex = listOf(0, 31, 61)
val monthSubmissions = listOf(146, 132, 158)

fun textColorFor(background: Color): Color =
    if (background == Color(0xFFE7E9ED) || background == Color(0xFFBFEACB)) TextPrimary else Color.White

@Composable
fun ActivitySubmissionCard(modifier: Modifier = Modifier,onCardClick: () -> Unit = {}) {
    var monthIndex by remember { mutableIntStateOf(0) }

    Card(
        modifier = modifier.clickable(onClick = onCardClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Activity & Submissions",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "${monthSubmissions[monthIndex]} submissions this month",
                        fontSize = 13.sp,
                        color = TextSecondary
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                MonthSelector(
                    monthLabel = monthLabels[monthIndex],
                    onPreviousClick = { if (monthIndex > 0) monthIndex-- },
                    onNextClick = { if (monthIndex < 2) monthIndex++ }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            CalendarGrid(
                daysInMonth = monthDaysInMonth[monthIndex],
                startOffset = monthStartOffset[monthIndex],
                monthStartIndex = monthStartIndex[monthIndex]
            )

            Spacer(modifier = Modifier.height(12.dp))

            HeatmapLegend()
        }
    }
}

@Composable
fun MonthSelector(
    monthLabel: String,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Background)
            .padding(horizontal = 4.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPreviousClick, modifier = Modifier.size(28.dp)) {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Previous month", tint = TextSecondary)
        }
        Text(monthLabel, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
        IconButton(onClick = onNextClick, modifier = Modifier.size(28.dp)) {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Next month", tint = TextSecondary)
        }
    }
}



@Composable
fun HeatmapLegend() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Less", fontSize = 12.sp, color = TextSecondary)
        Spacer(modifier = Modifier.width(6.dp))
        for (color in 1..4) {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(heatmapColors[color - 1])
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(text = "More", fontSize = 12.sp, color = TextSecondary)
    }
}
