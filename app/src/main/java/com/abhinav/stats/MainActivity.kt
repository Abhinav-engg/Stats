package com.abhinav.stats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abhinav.stats.presentation.navigation.StatsNavGraph
import com.abhinav.stats.ui.theme.StatsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatsTheme {
                StatsNavGraph()
            }
        }
    }
}
