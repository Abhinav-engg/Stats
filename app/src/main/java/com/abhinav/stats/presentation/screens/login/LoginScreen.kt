package com.abhinav.stats.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhinav.stats.ui.theme.Background

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    whenContinueIsClicked: (String) -> Unit = {}
) {
    Scaffold(containerColor = Background) { padding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(padding)
                .imePadding()
        ) {
            if (maxWidth > maxHeight) {
                LandscapeContent(
                    username = viewModel.username,
                    onUsernameChange = viewModel::onUsernameChange,
                    usernameError = viewModel.usernameError,
                    onContinueClick = { viewModel.onContinueClick(whenContinueIsClicked) }
                )
            } else {
                PortraitContent(
                    username = viewModel.username,
                    onUsernameChange = viewModel::onUsernameChange,
                    usernameError = viewModel.usernameError,
                    onContinueClick = { viewModel.onContinueClick(whenContinueIsClicked) }
                )
            }
        }
    }
}