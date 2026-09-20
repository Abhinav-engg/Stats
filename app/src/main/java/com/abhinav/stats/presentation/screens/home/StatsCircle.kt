package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.data.MockData
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.Background
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.Secondary
import com.abhinav.stats.ui.theme.Tertiary
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun StatsCircle() {
    val stats = MockData.userStats
    val solvedProblems = listOf(stats.easySolved, stats.mediumSolved, stats.hardSolved)
    val totalProblems = listOf(stats.easyTotal, stats.mediumTotal, stats.hardTotal)
    val colors = listOf(Secondary, Primary, Tertiary)

    Box(
        modifier = Modifier.size(190.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 14.dp.toPx()
            val circleSize = size.minDimension - strokeWidth
            val topLeft = androidx.compose.ui.geometry.Offset(strokeWidth / 2, strokeWidth / 2)

            var startAngle = -90f
            solvedProblems.forEachIndexed { index, solved ->
                val categoryTotal = totalProblems[index]
                val categorySweep = categoryTotal.toFloat() / stats.totalProblems * 348f
                val solvedSweep = solved.toFloat() / categoryTotal * categorySweep

                drawArc(
                    color = Divider,
                    startAngle = startAngle,
                    sweepAngle = categorySweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = androidx.compose.ui.geometry.Size(circleSize, circleSize),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = solvedSweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = androidx.compose.ui.geometry.Size(circleSize, circleSize),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round)
                )
                startAngle += categorySweep + 4f
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stats.totalSolved.toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = "/ ${stats.totalProblems} Solved",
                fontSize = 14.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .background(Background, RoundedCornerShape(8.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "${stats.acceptanceRate} Acct.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Secondary
                )
            }
        }
    }
}
