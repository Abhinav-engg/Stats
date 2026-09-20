package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.data.MockData
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.Surface
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun BadgesCard(modifier: Modifier = Modifier) {
    val regularBadges = MockData.badges.filterNot { it.isRecent }
    val recentBadge = MockData.badges.firstOrNull { it.isRecent }

    Card(modifier, RoundedCornerShape(20.dp), CardDefaults.cardColors(containerColor = Surface)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("Badges", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                Spacer(modifier = Modifier.weight(1f))
                Text(MockData.badges.size.toString(), color = TextSecondary)
            }

            regularBadges.chunked(2).forEach { badgeRow ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    badgeRow.forEach { badge ->
                        BadgeItem(badge.title, Modifier.weight(1f))
                    }
                    if (badgeRow.size == 1) Spacer(modifier = Modifier.weight(1f))
                }
            }

        }
    }
}
