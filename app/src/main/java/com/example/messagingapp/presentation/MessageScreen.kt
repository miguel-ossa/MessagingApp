package com.example.messagingapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.messagingapp.model.User

/**
 * Main message screen for the messaging app
 */
@Composable
fun MessageScreen(
    currentUser: User?,
    onLogout: () -> Unit
) {
    var messages by remember { mutableStateOf(listOf<String>()) }
    var newMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome, ${currentUser?.username ?: "User"}!",
                style = MaterialTheme.typography.headlineSmall
            )
            Button(onClick = onLogout) {
                Text("Logout")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Message list (simplified for demo)
        messages.forEach { message ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Message input
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = newMessage,
                onValueChange = { newMessage = it },
                label = { Text("Type a message...") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            Button(onClick = {
                if (newMessage.isNotEmpty()) {
                    messages = messages + newMessage
                    newMessage = ""
                }
            }) {
                Text("Send")
            }
        }
    }
}