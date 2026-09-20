package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(username: String) {
    Scaffold(topBar={HomeTopAppBar(username = username) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment=Alignment.CenterHorizontally
        ) {
            StatsSummaryCard()
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                BadgesCard(modifier = Modifier.weight(1f)
                    .fillMaxHeight()
                )
                TopLanguagesCard(modifier = Modifier.weight(1f)
                    .fillMaxHeight())
            }
        }
    }
}

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
        actions = {
            Text(
                text = "🔥 7 day streak",
                modifier = Modifier.padding(end = 16.dp),
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )
        }
    )
}
