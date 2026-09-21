package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abhinav.stats.ui.theme.Divider
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun DifficultyProgressRow(label: String, solved: Int, total: Int, color: Color) {
    val progress = solved.toFloat() / total

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = label, color = color, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$solved / $total",
                color = TextSecondary,
                fontWeight = FontWeight.SemiBold
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(10.dp)
                .background(Divider, RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .height(10.dp)
                    .background(color, RoundedCornerShape(12.dp))
            )
        }
    }
}