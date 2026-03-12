package com.example.messagingapp.domain

import com.example.messagingapp.data.DataSource
import com.example.messagingapp.model.User
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case for logging in a user
 */
class LoginUseCase @Inject constructor(private val dataSource: DataSource) {
    suspend operator fun invoke(username: String, password: String): Result<User> {
        return try {
            // In a real implementation, this would:
            // 1. Validate credentials against backend
            // 2. Authenticate with server
            // 3. Retrieve user data
            // For now, we'll simulate a login by finding an existing user

            // This is a simplified version - in reality, you'd want to:
            // - Hash the password before comparing
            // - Use secure authentication methods (JWT, OAuth, etc.)
            // - Handle network calls properly

            val users = dataSource.getUsers().first()
            val user = users.find { it.username == username }

            if (user != null) {
                Result.success(user)
            } else {
                Result.failure(Exception("User not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}