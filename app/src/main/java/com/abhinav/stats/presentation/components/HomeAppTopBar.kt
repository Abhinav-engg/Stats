package com.abhinav.stats.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(username: String) {
    TopAppBar(
        title = {
            Text(
                text = "@$username",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        },
    )
}