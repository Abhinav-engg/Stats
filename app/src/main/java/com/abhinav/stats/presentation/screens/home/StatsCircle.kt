package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.data.UserStats
import com.abhinav.stats.ui.theme.Background
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.Secondary
import com.abhinav.stats.ui.theme.Tertiary
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun StatsCircle(userStats: UserStats) {
    val solvedProblems = listOf(userStats.easySolved, userStats.mediumSolved, userStats.hardSolved)
    val totalProblems = listOf(userStats.easyTotal, userStats.mediumTotal, userStats.hardTotal)
    val colors = listOf(Secondary, Primary, Tertiary)

    Box(
        modifier = Modifier.size(190.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 14.dp.toPx()
            val circleSize = size.minDimension - strokeWidth
            val topLeft = Offset(strokeWidth / 2, strokeWidth / 2)

            var startAngle = -90f
            solvedProblems.forEachIndexed { index, solved ->
                val categoryTotal = totalProblems[index]
                val categorySweep = categoryTotal.toFloat() / userStats.totalProblems * 348f
                val solvedSweep = solved.toFloat() / categoryTotal * categorySweep

                drawArc(
                    color = Divider,
                    startAngle = startAngle,
                    sweepAngle = categorySweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = Size(circleSize, circleSize),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = solvedSweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = Size(circleSize, circleSize),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
                startAngle += categorySweep + 4f
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.widthIn(max = 130.dp)
        ) {
            Text(
                text = userStats.totalSolved.toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "/ ${userStats.totalProblems} Solved",
                fontSize = 14.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .widthIn(max = 120.dp)
                    .background(Background, RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "${userStats.acceptanceRate} Acct.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Secondary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}