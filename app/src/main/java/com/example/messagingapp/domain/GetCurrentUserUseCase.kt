package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Use case for getting the currently logged-in user
 */
class GetCurrentUserUseCase @Inject constructor(private val dataSource: DataSource) {
    operator fun invoke(): Flow<User?> {
        // For demo purposes, we'll simulate a current user
        // In a real app, this would get the current user from shared preferences, secure storage,
        // or a session manager.

        // Create a simple in-memory user for demonstration
        val currentUser = User(
            id = "current_user",
            username = "demo_user",
            email = "demo@example.com",
            password = "password123", // In real app this would be hashed
            publicKey = "demo_public_key",
            createdAt = System.currentTimeMillis()
        )

        // Return a flow that emits the current user
        val flow = MutableStateFlow<User?>(currentUser)
        return flow.asStateFlow()
    }
}