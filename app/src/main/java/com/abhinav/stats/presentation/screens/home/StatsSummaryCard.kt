package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.data.MockData
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.Secondary
import com.abhinav.stats.ui.theme.Surface
import com.abhinav.stats.ui.theme.Tertiary
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary
import androidx.compose.foundation.BorderStroke

@Composable
fun StatsSummaryCard() {
    val stats = MockData.userStats

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Surface),
        border = BorderStroke(1.dp, Divider)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .weight(1.5f)
                        .border(1.dp, Primary.copy(alpha = 0.45f), RoundedCornerShape(28.dp))
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = Primary
                    )
                    Text(
                        text = stats.topPercentage,
                        modifier = Modifier.padding(start = 8.dp),
                        color = TextPrimary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
                Text(
                    text = "Global Rank\n${stats.globalRank}",
                    modifier = Modifier.weight(0.85f),
                    color = TextSecondary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp),
                contentAlignment = Alignment.Center
            ) {
                StatsCircle()
            }

            DifficultyProgressRow(
                label = "Easy",
                solved = stats.easySolved,
                total = stats.easyTotal,
                color = Secondary
            )
            Spacer(modifier = Modifier.height(18.dp))
            DifficultyProgressRow(
                label = "Medium",
                solved = stats.mediumSolved,
                total = stats.mediumTotal,
                color = Primary
            )
            Spacer(modifier = Modifier.height(18.dp))
            DifficultyProgressRow(
                label = "Hard",
                solved = stats.hardSolved,
                total = stats.hardTotal,
                color = Tertiary
            )
        }
    }
}


