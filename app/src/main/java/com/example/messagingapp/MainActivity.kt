package com.example.messagingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messagingapp.presentation.MessageScreen
import com.example.messagingapp.presentation.LoginScreen
import com.example.messagingapp.presentation.RegisterScreen
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
                    // Main screen content
                    val navController = rememberNavController()
                    val viewModel: MessageViewModel = viewModel()

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(onLoginSuccess = { user ->
                                // After successful login, navigate to main message screen
                                navController.navigate("messages")
                            }, onNavigateToRegister = {
                                // Navigate to register screen
                                navController.navigate("register")
                            }, viewModel = viewModel)
                        }
                        composable("register") {
                            RegisterScreen(onRegisterSuccess = { user ->
                                // After successful registration, navigate to main message screen
                                navController.navigate("messages")
                            }, onNavigateToLogin = {
                                // Navigate back to login screen
                                navController.navigate("login")
                            }, viewModel = viewModel)
                        }
                        composable("messages") {
                            val currentUser by viewModel.currentUser.collectAsState()
                            MessageScreen(
                                currentUser = currentUser,
                                onLogout = {
                                    // Handle logout - in a real app this would navigate back to login
                                    navController.navigate("login")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
