package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.data.LanguageStat
import com.abhinav.stats.ui.theme.Background
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.Secondary
import com.abhinav.stats.ui.theme.Surface
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun TopLanguagesCard(
    topLanguages: List<LanguageStat>,
    coreTopics: List<String>,
    modifier: Modifier = Modifier
) {
    Card(modifier, RoundedCornerShape(20.dp), CardDefaults.cardColors(containerColor = Surface)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                "Top languages",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            topLanguages.forEachIndexed { index, language ->
                val dotColor = when (index) {
                    0 -> Primary
                    1 -> Secondary
                    else -> Color(0xFF2AA7E1)
                }
                LanguageRow(language, dotColor)
            }


        }
    }
}

@Composable
fun LanguageRow(language: LanguageStat, dotColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(Background, RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier
            .size(12.dp)
            .background(dotColor, CircleShape))
        Text(
            language.name,
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
            color = TextPrimary,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            language.problemsSolved.toString(),
            modifier = Modifier.padding(start = 8.dp),
            color = TextSecondary,
            fontWeight = FontWeight.SemiBold
        )
    }
}