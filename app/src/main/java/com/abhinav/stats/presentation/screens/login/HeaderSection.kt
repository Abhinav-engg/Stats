package com.abhinav.stats.presentation.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.TextPrimary
import com.abhinav.stats.ui.theme.TextSecondary

@Composable
fun HeaderSection(iconSize: Dp, titleSize: TextUnit) {
    Box(
        Modifier
            .size(iconSize)
            .clip(RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Code,
            contentDescription = null,
            tint = Primary,
            modifier = Modifier.size(iconSize)
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "LeetCode Stats",
        fontSize = titleSize,
        fontWeight = FontWeight.Bold,
        color = TextPrimary,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Enter your LeetCode username",
        fontSize = 14.sp,
        color = TextSecondary,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .widthIn(max = 320.dp)
            .padding(horizontal = 8.dp)
    )
}
