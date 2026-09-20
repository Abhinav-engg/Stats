package com.abhinav.stats.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.abhinav.stats.ui.theme.Background

@Composable
fun LoginScreen(whenContinueIsClicked: (String) -> Unit = {

}) {
    var username by remember { mutableStateOf("") }

    Scaffold(containerColor = Background) { padding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(padding)
        ) {
            if (maxWidth > maxHeight) {
                LandscapeContent(
                    username = username,
                    onUsernameChange = { username = it },
                    onContinueClick = { whenContinueIsClicked(username) }
                )
            } else {
                PortraitContent(
                    username = username,
                    onUsernameChange = { username = it },
                    onContinueClick = { whenContinueIsClicked(username) }
                )
            }
        }
    }
}
