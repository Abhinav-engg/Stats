package com.abhinav.stats.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhinav.stats.presentation.components.HomeTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    username: String,
    viewModel: HomeViewModel = viewModel(),
    onActivityHistoryClick: () -> Unit = {}
) {
    LaunchedEffect(username) {
        viewModel.loadStats(username)
    }

    Scaffold(topBar = { HomeTopAppBar(username = username) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StatsSummaryCard(userStats = viewModel.userStats)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                BadgesCard(
                    badges = viewModel.badges,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                TopLanguagesCard(
                    topLanguages = viewModel.topLanguages,
                    coreTopics = viewModel.coreTopics,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
//            ActivitySubmissionCard(
//                modifier = Modifier.fillMaxWidth(),
//                onCardClick = onActivityHistoryClick
//            )
//            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}