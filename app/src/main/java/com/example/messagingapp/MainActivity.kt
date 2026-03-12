package com.example.messagingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.messagingapp.presentation.MessageScreen
import com.example.messagingapp.presentation.LoginScreen
import com.example.messagingapp.presentation.MessageViewModel
import com.example.messagingapp.ui.theme.MessagingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessagingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MessageViewModel = viewModel()
                    // For demo purposes, we'll show the login screen first
                    // In a real app, you would check if user is already logged in
                    LoginScreen(onLoginSuccess = { user ->
                        // After successful login, navigate to main message screen
                        // This would typically be handled by a navigation component
                    })
                }
            }
        }
    }
}