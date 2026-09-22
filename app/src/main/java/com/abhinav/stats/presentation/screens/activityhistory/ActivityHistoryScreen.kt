//package com.abhinav.stats.presentation.screens.activityhistory
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
////import com.abhinav.stats.presentation.components.CalendarGrid
////import com.abhinav.stats.presentation.screens.home.monthLabels
////import com.abhinav.stats.presentation.screens.home.monthSubmissions
////import com.abhinav.stats.presentation.screens.home.monthDaysInMonth
////import com.abhinav.stats.presentation.screens.home.monthStartOffset
////import com.abhinav.stats.presentation.screens.home.monthStartIndex
////import com.abhinav.stats.presentation.screens.home.HeatmapLegend
//import com.abhinav.stats.ui.theme.Background
//import com.abhinav.stats.ui.theme.StatsTheme
//import com.abhinav.stats.ui.theme.Surface
//import com.abhinav.stats.ui.theme.TextPrimary
//import com.abhinav.stats.ui.theme.TextSecondary
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ActivityHistoryScreen(onBackClick: () -> Unit = {}) {
//    Scaffold(
//        containerColor = Background,
//        topBar = {
//            TopAppBar(
//                title = { Text("Activity History", fontWeight = FontWeight.Bold, color = TextPrimary) },
//                navigationIcon = {
//                    IconButton(onClick = onBackClick) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextPrimary)
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
//            )
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Background)
//                .padding(paddingValues)
//                .verticalScroll(rememberScrollState())
//                .padding(16.dp)
//        ) {
//            for (index in monthLabels.indices) {
//                MonthHistoryCard(index = index)
//                if (index != monthLabels.lastIndex) {
//                    Spacer(modifier = Modifier.height(16.dp))
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun MonthHistoryCard(index: Int) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(20.dp),
//        colors = CardDefaults.cardColors(containerColor = Surface),
//        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(
//                text = monthLabels[index],
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = TextPrimary
//            )
//            Text(
//                text = "${monthSubmissions[index]} submissions this month",
//                fontSize = 13.sp,
//                color = TextSecondary
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            CalendarGrid(
//                daysInMonth = monthDaysInMonth[index],
//                startOffset = monthStartOffset[index],
//                monthStartIndex = monthStartIndex[index]
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            HeatmapLegend()
//        }
//    }
//}
